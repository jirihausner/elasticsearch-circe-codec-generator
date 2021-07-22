package cz.jirihausner.es_codec_generator

import better.files.File
import java.io.File.separatorChar

object Configuration {
  val packageName: String = "org.elasticsearch.circecodecs"
  val inputDir: File = File.currentWorkingDirectory /
    "elasticsearch-specification" / "output" / "typescript"
  val outputDir: File = File.currentWorkingDirectory /
    "output" / "src" / "main" / "scala" / packageName.replace('.', separatorChar)
}
