package com.converted.elasticsearch._global.get_script_context

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Context(
	methods: Seq[ContextMethod], 
	name: Name
)

@JsonCodec case class ContextMethod(
	name: Name, 
	return_type: String, 
	params: Seq[ContextMethodParam]
)

@JsonCodec case class ContextMethodParam(
	name: Name, 
	`type`: String
)
