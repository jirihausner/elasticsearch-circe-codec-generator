package com.converted.elasticsearch.slm.get_status

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Lifecycle.{ LifecycleOperationMode }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		operation_mode: LifecycleOperationMode
	)
}

