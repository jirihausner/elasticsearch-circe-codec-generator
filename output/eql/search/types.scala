package com.converted.elasticsearch.eql.search

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }

@JsonCodec case class SearchFieldFormatted(
	field: Field, 
	format: String
)

object ResultPosition extends Enumeration {
	type ResultPosition = Value

	val tail = Value(0, "tail")
	val head = Value(1, "head")
}

implicit val resultPositionDecoder: Decoder[ResultPosition.Value] = Decoder.decodeEnumeration(ResultPosition)
implicit val resultPositionEncoder: Encoder[ResultPosition.Value] = Decoder.encodeEnumeration(ResultPosition)
