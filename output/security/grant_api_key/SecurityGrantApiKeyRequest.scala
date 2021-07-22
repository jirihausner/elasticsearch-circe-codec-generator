package com.converted.elasticsearch.security.grant_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Password, Username }
import com.converted.elasticsearch.security.grant_api_key.{ ApiKey, ApiKeyGrantType }

@JsonCodec case class Request(
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class Body(
		api_key: ApiKey, 
		grant_type: ApiKeyGrantType, 
		access_token: String, 
		username: Username, 
		password: Password
	)
}

