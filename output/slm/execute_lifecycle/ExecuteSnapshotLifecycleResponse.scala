package com.converted.elasticsearch.slm.execute_lifecycle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		snapshot_name: Name
	)
}

