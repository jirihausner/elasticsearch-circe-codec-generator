package com.converted.elasticsearch.task.list

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._task._types.TaskInfo.{ Info }
import com.converted.elasticsearch._types.Errors.{ ErrorCause }
import com.converted.elasticsearch.task.list.{ TaskExecutingNode }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		node_failures: Seq[ErrorCause], 
		nodes: Dictionary[String, TaskExecutingNode], 
		tasks: Dictionary[String, Info] | Seq[Info]
	)
}

