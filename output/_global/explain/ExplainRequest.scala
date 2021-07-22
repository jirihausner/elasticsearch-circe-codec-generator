package com.converted.elasticsearch._global.explain

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ DefaultOperator, Fields, Id, IndexName, Routing, Type }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id, 
		index: IndexName, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		analyzer: String, 
		analyze_wildcard: Boolean, 
		default_operator: DefaultOperator, 
		df: String, 
		lenient: Boolean, 
		preference: String, 
		query_on_query_string: String, 
		routing: Routing, 
		_source: Boolean | Fields, 
		_source_excludes: Fields, 
		_source_includes: Fields, 
		stored_fields: Fields, 
		q: String
	)
	@JsonCodec case class Body(
		query: QueryContainer
	)
}

