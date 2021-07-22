package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object FielddataLoading extends Enumeration {
	type FielddataLoading = Value

	val eager = Value(0, "eager")
	val eager_global_ordinals = Value(1, "eager_global_ordinals")
}

implicit val fielddataLoadingDecoder: Decoder[FielddataLoading.Value] = Decoder.decodeEnumeration(FielddataLoading)
implicit val fielddataLoadingEncoder: Encoder[FielddataLoading.Value] = Decoder.encodeEnumeration(FielddataLoading)
