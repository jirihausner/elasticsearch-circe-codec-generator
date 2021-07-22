package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object NumericFielddataFormat extends Enumeration {
	type NumericFielddataFormat = Value

	val array = Value(0, "array")
	val disabled = Value(1, "disabled")
}

implicit val numericFielddataFormatDecoder: Decoder[NumericFielddataFormat.Value] = Decoder.decodeEnumeration(NumericFielddataFormat)
implicit val numericFielddataFormatEncoder: Encoder[NumericFielddataFormat.Value] = Decoder.encodeEnumeration(NumericFielddataFormat)
