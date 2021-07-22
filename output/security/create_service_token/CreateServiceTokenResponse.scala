package com.converted.elasticsearch.security.create_service_token

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.security.create_service_token.{ Token }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		created: Boolean, 
		token: Token
	)
}

