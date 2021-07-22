package com.converted.elasticsearch.indices.resolve_index

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Names }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Names
	)
	@JsonCodec case class QueryParameters(
		expand_wildcards: ExpandWildcards
	)
	@JsonCodec case class Body(
	)
}

