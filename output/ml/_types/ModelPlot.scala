package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }

@JsonCodec case class ModelPlotConfig(
	terms: Field, 
	enabled: Boolean, 
	annotations_enabled: Boolean
)


@JsonCodec case class ModelPlotConfigEnabled(
	enabled: Boolean, 
	annotations_enabled: Boolean, 
	terms: String
)

