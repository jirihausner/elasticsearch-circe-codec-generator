package com.converted.elasticsearch.ilm.move_to_step

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class StepKey(
	action: String, 
	name: String, 
	phase: String
)
