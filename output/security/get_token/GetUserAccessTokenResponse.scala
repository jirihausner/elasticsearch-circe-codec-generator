package com.converted.elasticsearch.security.get_token

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch.security.get_token.{ AuthenticatedUser }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		access_token: String, 
		expires_in: Long, 
		scope: String, 
		`type`: String, 
		refresh_token: String, 
		kerberos_authentication_response_token: String, 
		authentication: AuthenticatedUser
	)
}

