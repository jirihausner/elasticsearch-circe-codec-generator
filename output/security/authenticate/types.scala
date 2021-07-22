package com.converted.elasticsearch.security.authenticate

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Token(
	name: Name
)
