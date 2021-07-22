package com.converted.elasticsearch._global.scripts_painless_execute

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class Response[TResult](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		result: TResult
	)
}

