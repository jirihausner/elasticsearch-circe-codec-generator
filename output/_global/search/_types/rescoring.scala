package com.converted.elasticsearch._global.search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ double, integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class Rescore(
	query: RescoreQuery, 
	window_size: integer
)


@JsonCodec case class RescoreQuery(
	rescore_query: QueryContainer, 
	query_weight: double, 
	rescore_query_weight: double, 
	score_mode: ScoreMode
)


object ScoreMode extends Enumeration {
	type ScoreMode = Value

val avg = Value(0, "avg")
val max = Value(1, "max")
val min = Value(2, "min")
val multiply = Value(3, "multiply")
val total = Value(4, "total")
}

implicit val scoreModeDecoder: Decoder[ScoreMode.Value] = Decoder.decodeEnumeration(ScoreMode)
implicit val scoreModeEncoder: Encoder[ScoreMode.Value] = Decoder.encodeEnumeration(ScoreMode)

