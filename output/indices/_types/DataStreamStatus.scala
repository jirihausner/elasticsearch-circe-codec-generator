package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object DataStreamHealthStatus extends Enumeration {
	type DataStreamHealthStatus = Value

	val gREEN = Value(0, "GREEN")
	val green = Value(1, "green")
	val yELLOW = Value(2, "YELLOW")
	val yellow = Value(3, "yellow")
	val rED = Value(4, "RED")
	val red = Value(5, "red")
}

implicit val dataStreamHealthStatusDecoder: Decoder[DataStreamHealthStatus.Value] = Decoder.decodeEnumeration(DataStreamHealthStatus)
implicit val dataStreamHealthStatusEncoder: Encoder[DataStreamHealthStatus.Value] = Decoder.encodeEnumeration(DataStreamHealthStatus)
