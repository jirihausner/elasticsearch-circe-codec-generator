package com.converted.elasticsearch.security.get_token

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Password, Username }
import com.converted.elasticsearch.security.get_token.{ AccessTokenGrantType }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
		grant_type: AccessTokenGrantType, 
		scope: String, 
		password: Password, 
		kerberos_ticket: String, 
		refresh_token: String, 
		username: Username
	)
}

