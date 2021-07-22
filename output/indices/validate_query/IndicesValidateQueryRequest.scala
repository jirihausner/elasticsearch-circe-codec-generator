package com.converted.elasticsearch.indices.validate_query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ DefaultOperator, ExpandWildcards, Indices, Types }
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
		all_shards: Boolean, 
		analyzer: String, 
		analyze_wildcard: Boolean, 
		default_operator: DefaultOperator, 
		df: String, 
		expand_wildcards: ExpandWildcards, 
		explain: Boolean, 
		ignore_unavailable: Boolean, 
		lenient: Boolean, 
		query_on_query_string: String, 
		rewrite: Boolean, 
		q: String
	)
	@JsonCodec case class Body(
		query: QueryContainer
	)
}

