version := "0.1"
name := "es_codec_generator"
scalaVersion := "2.12.12"
parallelExecution := true
idePackagePrefix := Some("cz.jirihausner.es_codec_generator")
libraryDependencies ++= Seq(
  "org.scalablytyped.converter" %% "ts"           % "1.0.0-beta34",
  "com.github.pathikrit"        %% "better-files" % "3.9.1",
  "org.scalatest"               %% "scalatest"    % "3.2.5",
  "org.scalatest"               %% "scalatest"    % "3.2.5"         % "test"
)