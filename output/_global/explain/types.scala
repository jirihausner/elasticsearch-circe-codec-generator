package com.converted.elasticsearch._global.explain

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ float }

@JsonCodec case class Explanation(
	description: String, 
	details: Array(ExplanationDetail), 
	value: float
)

@JsonCodec case class ExplanationDetail(
	description: String, 
	details: Array(ExplanationDetail), 
	value: float
)
