package com.converted.elasticsearch.text_structure.find_structure

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Numeric.{ integer, long }

@JsonCodec case class FieldStat(
	count: integer, 
	cardinality: integer, 
	top_hits: Array(TopHit), 
	mean_value: integer, 
	median_value: integer, 
	max_value: integer, 
	min_value: integer, 
	earliest: String, 
	latest: String
)


@JsonCodec case class TopHit(
	count: Long, 
	value: UserDefinedValue
)

