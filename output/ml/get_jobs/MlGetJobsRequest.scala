package com.converted.elasticsearch.ml.get_jobs

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Ids }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		job_id: Ids
	)
	@JsonCodec case class QueryParameters(
		allow_no_match: Boolean, 
		allow_no_jobs: Boolean, 
		exclude_generated: Boolean
	)
}

