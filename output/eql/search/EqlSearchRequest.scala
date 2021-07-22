package com.converted.elasticsearch.eql.search

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Field, IndexName }
import com.converted.elasticsearch._types.Numeric.{ float, uint }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Time.{ Time }
import com.converted.elasticsearch.eql.search.{ ResultPosition, SearchFieldFormatted }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		ignore_unavailable: Boolean, 
		keep_alive: Time, 
		keep_on_completion: Boolean, 
		wait_for_completion_timeout: Time
	)
	@JsonCodec case class Body(
		query: String, 
		case_sensitive: Boolean, 
		event_category_field: Field, 
		tiebreaker_field: Field, 
		timestamp_field: Field, 
		fetch_size: uint, 
		filter: QueryContainer | Array[QueryContainer], 
		keep_alive: Time, 
		keep_on_completion: Boolean, 
		wait_for_completion_timeout: Time, 
		size: uint | float, 
		fields: Array[Field | SearchFieldFormatted], 
		result_position: ResultPosition
	)
}

