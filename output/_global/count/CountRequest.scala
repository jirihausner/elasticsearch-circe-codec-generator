package com.converted.elasticsearch._global.count

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ DefaultOperator, ExpandWildcards, Indices, Routing, Types }
import com.converted.elasticsearch._types.Numeric.{ double, long }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		`type`: Types
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		analyzer: String, 
		analyze_wildcard: Boolean, 
		default_operator: DefaultOperator, 
		df: String, 
		expand_wildcards: ExpandWildcards, 
		ignore_throttled: Boolean, 
		ignore_unavailable: Boolean, 
		lenient: Boolean, 
		min_score: double, 
		preference: String, 
		query_on_query_string: String, 
		routing: Routing, 
		terminate_after: Long, 
		q: String
	)
	@JsonCodec case class Body(
		query: QueryContainer
	)
}

