package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.query_dsl.{ QueryBase }

@JsonCodec case class MatchAllQuery(
	norm_field: String
) extends QueryBase

