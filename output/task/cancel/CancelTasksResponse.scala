package com.converted.elasticsearch.task.cancel

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._task._types.TaskExecutingNode.{ TaskExecutingNode }
import com.converted.elasticsearch._types.Errors.{ ErrorCause }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		node_failures: Array[ErrorCause], 
		nodes: Dictionary[String, TaskExecutingNode]
	)
}

