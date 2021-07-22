package com.converted.elasticsearch.security.delete_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name, Refresh }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		application: Name, 
		name: Name
	)
	@JsonCodec case class QueryParameters(
		refresh: Refresh
	)
}

