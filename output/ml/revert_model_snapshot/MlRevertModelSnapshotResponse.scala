package com.converted.elasticsearch.ml.revert_model_snapshot

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Model.{ ModelSnapshot }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		model: ModelSnapshot
	)
}

