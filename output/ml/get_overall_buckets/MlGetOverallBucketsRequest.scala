package com.converted.elasticsearch.ml.get_overall_buckets

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ double, integer }
import com.converted.elasticsearch._types.Time.{ Time }

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
		bucket_span: Time, 
		overall_score: double | String, 
		top_n: integer, 
		end: Time, 
		start: Time, 
		exclude_interim: Boolean, 
		allow_no_match: Boolean
	)
	@JsonCodec case class Body(
		allow_no_jobs: Boolean
	)
}

