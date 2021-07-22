package com.converted.elasticsearch.security.grant_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, Name }
import com.converted.elasticsearch._types.Time.{ EpochMillis }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		api_key: String, 
		id: Id, 
		name: Name, 
		expiration: EpochMillis
	)
}

