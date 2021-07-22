package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object GeoPointFielddataFormat extends Enumeration {
	type GeoPointFielddataFormat = Value

	val array = Value(0, "array")
	val doc_values = Value(1, "doc_values")
	val compressed = Value(2, "compressed")
	val disabled = Value(3, "disabled")
}

implicit val geoPointFielddataFormatDecoder: Decoder[GeoPointFielddataFormat.Value] = Decoder.decodeEnumeration(GeoPointFielddataFormat)
implicit val geoPointFielddataFormatEncoder: Encoder[GeoPointFielddataFormat.Value] = Decoder.encodeEnumeration(GeoPointFielddataFormat)
