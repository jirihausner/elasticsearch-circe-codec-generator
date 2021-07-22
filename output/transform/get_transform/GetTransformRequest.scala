package com.converted.elasticsearch.transform.get_transform

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch._types.Numeric.{ integer }

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
		from: integer, 
		size: integer, 
		exclude_generated: Boolean
	)
}

