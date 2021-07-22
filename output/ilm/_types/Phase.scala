package com.converted.elasticsearch.ilm._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Phase(
	actions: Dictionary[String, Action] | Seq[String], 
	min_age: Time
)

@JsonCodec case class Phases(
	cold: Phase, 
	delete: Phase, 
	hot: Phase, 
	warm: Phase
)

@JsonCodec sealed trait Action
