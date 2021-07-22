package cz.jirihausner.es_codec_generator

import generator.Generator

import java.io.PrintWriter
import better.files.File
import better.files.File._
import java.io.File.separatorChar
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
    outputDir.createDirectoryIfNotExists(createParents = true)

    // get all typescript definition files in input directory
    val files: List[File] = inputDir.listRecursively.filter(_.extension.contains(".ts")).toList

    // parse files into definitions then convert and print them as equivalent scala code
    files.par.map(parse).foreach(res => res.fold(failed => println(failed), parsed => generate(parsed._1, parsed._2)))
  }

  def parse(file: File): Either[String, (File, TsParsedFile)] =
    parser.parseFile(InFile(os.Path(file.toJava))) match {
      case Right(parsed) => Right((file, parsed))
      case Left(message) =>
        Left(s"Failed to parse '\\${File.currentWorkingDirectory.path.relativize(file)}'\nError: $message")
    }

  def generate(file: File, parsedFile: TsParsedFile): Unit = {
    // print message
    println(s"Successfully parsed '\\${File.currentWorkingDirectory.path.relativize(file)}'")

    // create output file
    val relativePath = inputDir.path.relativize(file)
    val outputFile: File = outputDir / relativePath.toString.replace(".ts", ".scala")
    outputFile.createIfNotExists(createParents = true)
    val output: PrintWriter = outputFile.newPrintWriter()

    // prepare file package name
    val hasSubDirectory: Boolean = relativePath.toString.contains(separatorChar)
    val filePackageName: String = {
      if (!hasSubDirectory) ""
      else relativePath.toString
        .replace(separatorChar, '.')
        .substring(0, relativePath.toString.lastIndexOf(separatorChar))
    }

    // generate equivalent scala code from typescript AST and print it
    val generator = new Generator(output, filePackageName, packageName)
    generator.printFile(parsedFile)

    // close output stream
    output.close()

    // print message
    println(s"Successfully generated '\\${File.currentWorkingDirectory.relativize(outputFile)}'")
  }
}
