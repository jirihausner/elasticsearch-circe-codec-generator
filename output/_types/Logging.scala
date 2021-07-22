package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object LogLevel extends Enumeration {
	type LogLevel = Value

val error = Value(0, "error")
val warn = Value(1, "warn")
val info = Value(2, "info")
val debug = Value(3, "debug")
val trace = Value(4, "trace")
}

implicit val logLevelDecoder: Decoder[LogLevel.Value] = Decoder.decodeEnumeration(LogLevel)
implicit val logLevelEncoder: Encoder[LogLevel.Value] = Decoder.encodeEnumeration(LogLevel)

