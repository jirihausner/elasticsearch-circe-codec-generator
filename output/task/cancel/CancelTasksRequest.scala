package com.converted.elasticsearch.task.cancel

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ TaskId }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		task_id: TaskId
	)
	@JsonCodec case class QueryParameters(
		actions: String | Array(String), 
		nodes: Array(String), 
		parent_task_id: String, 
		wait_for_completion: Boolean
	)
	@JsonCodec case class Body(
	)
}

