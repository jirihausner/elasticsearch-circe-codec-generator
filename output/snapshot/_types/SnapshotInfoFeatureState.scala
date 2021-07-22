package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Indices }

@JsonCodec case class InfoFeatureState(
	feature_name: String, 
	indices: Indices
)

