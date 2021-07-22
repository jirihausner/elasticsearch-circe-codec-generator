package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Filter(
	description: String, 
	filter_id: Id, 
	items: Array(String)
)

@JsonCodec case class FilterRef(
	filter_id: Id, 
	filter_type: FilterType
)

object FilterType extends Enumeration {
	type FilterType = Value

	val include = Value(0, "include")
	val exclude = Value(1, "exclude")
}

implicit val filterTypeDecoder: Decoder[FilterType.Value] = Decoder.decodeEnumeration(FilterType)
implicit val filterTypeEncoder: Encoder[FilterType.Value] = Decoder.encodeEnumeration(FilterType)
