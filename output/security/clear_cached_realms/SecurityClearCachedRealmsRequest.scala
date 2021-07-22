package com.converted.elasticsearch.security.clear_cached_realms

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Names }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		realms: Names
	)
	@JsonCodec case class QueryParameters(
		usernames: Array[String]
	)
	@JsonCodec case class Body(
	)
}

