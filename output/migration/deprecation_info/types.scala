package com.converted.elasticsearch.migration.deprecation_info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object DeprecationLevel extends Enumeration {
	type DeprecationLevel = Value

	val none = Value(0, "none")
	val info = Value(1, "info")
	val warning = Value(2, "warning")
	val critical = Value(3, "critical")
}

implicit val deprecationLevelDecoder: Decoder[DeprecationLevel.Value] = Decoder.decodeEnumeration(DeprecationLevel)
implicit val deprecationLevelEncoder: Encoder[DeprecationLevel.Value] = Decoder.encodeEnumeration(DeprecationLevel)

@JsonCodec case class Deprecation(
	details: String, 
	level: DeprecationLevel, 
	message: String, 
	url: String
)
