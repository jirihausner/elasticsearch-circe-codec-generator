package com.converted.elasticsearch.security.get_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.security.get_api_key.{ ApiKey }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		api_keys: Seq[ApiKey]
	)
}

