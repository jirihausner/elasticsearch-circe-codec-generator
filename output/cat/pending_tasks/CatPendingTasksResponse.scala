package com.converted.elasticsearch.cat.pending_tasks

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.pending_tasks.{ PendingTasksRecord }

@JsonCodec case class Response(
	body: Array(PendingTasksRecord)
)

