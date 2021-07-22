package com.converted.elasticsearch.security.get_builtin_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Indices }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		cluster: Array[String], 
		index: Indices
	)
}

