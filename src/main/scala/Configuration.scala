package cz.jirihausner.es_codec_generator

import better.files.File
import java.io.File.separatorChar

object Configuration {
  /** name of output package */
  val packageName: String = "org.elasticsearch.circecodecs"

  /** input directory */
  val inputDir: File = File.currentWorkingDirectory / "elasticsearch-specification" / "specification"

  /** output directory */
  val outputDir: File = File.currentWorkingDirectory / "output" / "src" / "main" / "scala" /
    packageName.replace('.', separatorChar)

  /** whether to skip comments generation */
  val skipComments: Boolean = false

  /** output to single or multiple files (avoids includes) */
  val outputSingleFile: Boolean = false

  /** name of single output file */
  val singleFileName: String = "package.scala"
}
