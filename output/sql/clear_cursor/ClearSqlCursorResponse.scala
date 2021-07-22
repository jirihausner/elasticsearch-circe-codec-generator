package com.converted.elasticsearch.sql.clear_cursor

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		succeeded: Boolean
	)
}

