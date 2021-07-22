package com.converted.elasticsearch.security.invalidate_token

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name, Username }

@JsonCodec case class Request(
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class Body(
		token: String, 
		refresh_token: String, 
		realm_name: Name, 
		username: Username
	)
}

