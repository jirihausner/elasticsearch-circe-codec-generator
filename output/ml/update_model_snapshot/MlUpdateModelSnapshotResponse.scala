package com.converted.elasticsearch.ml.update_model_snapshot

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Model.{ ModelSnapshot }
import com.converted.elasticsearch._types.Base.{ AcknowledgedResponseBase }

@JsonCodec case class Response(
	body: Body
) extends AcknowledgedResponseBase

object Response {
	@JsonCodec case class Body(
		model: ModelSnapshot
	)
}

