package com.converted.elasticsearch.cluster.pending_tasks

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cluster.pending_tasks.{ PendingTask }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		tasks: Array[PendingTask]
	)
}

