package com.converted.elasticsearch._global.get_script_context

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.get_script_context.{ Context }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		contexts: Array(Context)
	)
}

