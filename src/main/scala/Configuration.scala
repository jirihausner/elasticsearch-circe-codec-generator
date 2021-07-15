package cz.jirihausner.es_codec_generator

import better.files.File

object Configuration {
  val inputDir: File = File.currentWorkingDirectory / "specification"
  val outputDir: File = File.currentWorkingDirectory / "output"
  val packageName: String = "com.converted.elasticsearch"
}
