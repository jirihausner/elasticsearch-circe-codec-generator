package com.converted.elasticsearch._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.mapping.{ PropertyBase }

@JsonCodec case class DynamicTemplate(
	mapping: PropertyBase, 
	`match`: String, 
	match_mapping_type: String, 
	match_pattern: MatchType, 
	path_match: String, 
	path_unmatch: String, 
	unmatch: String
)

object MatchType extends Enumeration {
	type MatchType = Value

	val simple = Value(0, "simple")
	val regex = Value(1, "regex")
}

implicit val matchTypeDecoder: Decoder[MatchType.Value] = Decoder.decodeEnumeration(MatchType)
implicit val matchTypeEncoder: Encoder[MatchType.Value] = Decoder.encodeEnumeration(MatchType)

object DynamicMapping extends Enumeration {
	type DynamicMapping = Value

	val strict = Value(0, "strict")
	val runtime = Value(1, "runtime")
	val true = Value(2, "true")
	val false = Value(3, "false")
}

implicit val dynamicMappingDecoder: Decoder[DynamicMapping.Value] = Decoder.decodeEnumeration(DynamicMapping)
implicit val dynamicMappingEncoder: Encoder[DynamicMapping.Value] = Decoder.encodeEnumeration(DynamicMapping)
