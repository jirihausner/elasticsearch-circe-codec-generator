package com.converted.elasticsearch._types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }

@JsonCodec case class Aggregation(
	meta: Dictionary(String, UserDefinedValue), 
	name: String
)
