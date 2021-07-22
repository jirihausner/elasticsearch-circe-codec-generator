package com.converted.elasticsearch.watcher.deactivate_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._watcher._types.Activation.{ ActivationStatus }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		status: ActivationStatus
	)
}

