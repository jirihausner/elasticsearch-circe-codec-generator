package com.converted.elasticsearch.ml.upgrade_job_snapshot

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ NodeId }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		node: NodeId, 
		completed: Boolean
	)
}

