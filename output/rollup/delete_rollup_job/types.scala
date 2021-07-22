package com.converted.elasticsearch.rollup.delete_rollup_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, TaskId }

@JsonCodec case class TaskFailure(
	task_id: TaskId, 
	node_id: Id, 
	status: String, 
	reason: TaskFailureReason
)

@JsonCodec case class TaskFailureReason(
	`type`: String, 
	reason: String
)
