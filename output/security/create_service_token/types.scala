package com.converted.elasticsearch.security.create_service_token

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Token(
	name: Name, 
	value: String
)

