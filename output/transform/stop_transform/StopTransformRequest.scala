package com.converted.elasticsearch.transform.stop_transform

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		transform_id: Name
	)
	@JsonCodec case class QueryParameters(
		allow_no_match: Boolean, 
		force: Boolean, 
		timeout: Time, 
		wait_for_checkpoint: Boolean, 
		wait_for_completion: Boolean
	)
}

