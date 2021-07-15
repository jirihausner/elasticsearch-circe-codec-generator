package cz.jirihausner.es_codec_generator

import generator.Generator

import java.io.PrintWriter
import java.nio.file.Path
import better.files.File
import better.files.File._
import org.scalablytyped.converter.internal.InFile
import org.scalablytyped.converter.internal.ts.{TsParsedFile, parser}

object Main {

  /** import configuration */
  import Configuration._

  def main(args: Array[String]): Unit = {
    // create input and output dir if neccessary
    if (!inputDir.exists)
      inputDir.createDirectory
    if (outputDir.exists)
      outputDir.delete(swallowIOExceptions = true)
    outputDir.createDirectory

    // get all typescript definition files in input directory
    val files: List[File] = inputDir.listRecursively.filter(_.extension.contains(".ts")).toList

    // parse files into definitions then convert and print them as equivalent scala code
    files.par.map(parse).foreach(res => res.fold(_ => Console.println(_), parsed => generate(parsed._1, parsed._2)))
  }

  def parse(file: File): Either[String, (Path, TsParsedFile)] =
    parser.parseFile(InFile(os.Path(file.toJava))) match {
      case Right(parsed) => Right((inputDir.path.relativize(file), parsed))
      case Left(message) => Left(message)
    }

  def generate(relativePath: Path, parsedFile: TsParsedFile): Unit = {
    // create output file
    val outputFile: File = outputDir / relativePath
    outputFile.changeExtensionTo("scala")
    outputFile.createIfNotExists(createParents = true)
    val output: PrintWriter = outputFile.newPrintWriter()

    // prepare file package name
    val filePackageName: String = relativePath.parent.toString.replace('/', '.')

    // generate equivalent scala code from typescript AST and print it
    val generator = new Generator(output, filePackageName, packageName)
    generator.printFile(parsedFile)
  }
}
