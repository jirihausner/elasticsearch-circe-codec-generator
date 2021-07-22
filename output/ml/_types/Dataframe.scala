package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object DataframeState extends Enumeration {
	type DataframeState = Value

val started = Value(0, "started")
val stopped = Value(1, "stopped")
val starting = Value(2, "starting")
val stopping = Value(3, "stopping")
val failed = Value(4, "failed")
}

implicit val dataframeStateDecoder: Decoder[DataframeState.Value] = Decoder.decodeEnumeration(DataframeState)
implicit val dataframeStateEncoder: Encoder[DataframeState.Value] = Decoder.encodeEnumeration(DataframeState)

