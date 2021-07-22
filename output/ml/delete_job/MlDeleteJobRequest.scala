package com.converted.elasticsearch.ml.delete_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		job_id: Id
	)
	@JsonCodec case class QueryParameters(
		force: Boolean, 
		wait_for_completion: Boolean
	)
}

