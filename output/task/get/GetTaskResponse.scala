package com.converted.elasticsearch.task.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._task._types.TaskStatus.{ Status }
import com.converted.elasticsearch._types.Errors.{ ErrorCause }
import com.converted.elasticsearch.task.get.{ Info }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		completed: Boolean, 
		task: Info, 
		response: Status, 
		error: ErrorCause
	)
}

