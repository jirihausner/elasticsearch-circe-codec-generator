package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object StringFielddataFormat extends Enumeration {
	type StringFielddataFormat = Value

val paged_bytes = Value(0, "paged_bytes")
val disabled = Value(1, "disabled")
}

implicit val stringFielddataFormatDecoder: Decoder[StringFielddataFormat.Value] = Decoder.decodeEnumeration(StringFielddataFormat)
implicit val stringFielddataFormatEncoder: Encoder[StringFielddataFormat.Value] = Decoder.encodeEnumeration(StringFielddataFormat)

