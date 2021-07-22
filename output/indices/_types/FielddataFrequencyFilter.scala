package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ double, integer }

@JsonCodec case class FielddataFrequencyFilter(
	max: double, 
	min: double, 
	min_segment_size: integer
)
