version := "1.0"
name := "elasticsearch-circe-codecs"
scalaVersion := "2.13.3"
scalacOptions ++= Seq(
  "-encoding", "utf8",
  "-Ymacro-annotations"
)

// circle
val circeVersion = "0.14.1"
libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
addCompilerPlugin(
  "org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full
)