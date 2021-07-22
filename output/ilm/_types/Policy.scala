package com.converted.elasticsearch.ilm._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch.ilm._types.{ Phases }

@JsonCodec case class Policy(
	phases: Phases, 
	name: Name
)
