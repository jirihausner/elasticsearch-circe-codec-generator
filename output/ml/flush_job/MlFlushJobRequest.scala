package com.converted.elasticsearch.ml.flush_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		job_id: Id
	)
	@JsonCodec case class QueryParameters(
		skip_time: String
	)
	@JsonCodec case class Body(
		advance_time: DateString, 
		calc_interim: Boolean, 
		end: DateString, 
		start: DateString
	)
}

