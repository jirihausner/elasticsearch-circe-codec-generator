package com.converted.elasticsearch.task.list

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ GroupBy, Id }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		actions: String | Seq[String], 
		detailed: Boolean, 
		group_by: GroupBy, 
		nodes: Seq[String], 
		parent_task_id: Id, 
		timeout: Time, 
		wait_for_completion: Boolean
	)
	@JsonCodec case class Body(
	)
}

