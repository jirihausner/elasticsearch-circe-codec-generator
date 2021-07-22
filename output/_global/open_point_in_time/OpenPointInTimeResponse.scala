package com.converted.elasticsearch._global.open_point_in_time

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		id: Id
	)
}

