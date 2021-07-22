package com.converted.elasticsearch._global.delete_by_query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Conflicts, DefaultOperator, ExpandWildcards, Fields, Indices, Routing, SearchType, Types, WaitForActiveShards }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.SlicedScroll.{ SlicedScroll }
import com.converted.elasticsearch._types.Time.{ Time }

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
		conflicts: Conflicts, 
		default_operator: DefaultOperator, 
		df: String, 
		expand_wildcards: ExpandWildcards, 
		from: Long, 
		ignore_unavailable: Boolean, 
		lenient: Boolean, 
		max_docs: Long, 
		preference: String, 
		refresh: Boolean, 
		request_cache: Boolean, 
		requests_per_second: Long, 
		routing: Routing, 
		q: String, 
		scroll: Time, 
		scroll_size: Long, 
		search_timeout: Time, 
		search_type: SearchType, 
		size: Long, 
		slices: Long, 
		sort: Array(String), 
		_source: Boolean | Fields, 
		_source_excludes: Fields, 
		_source_includes: Fields, 
		stats: Array(String), 
		terminate_after: Long, 
		timeout: Time, 
		version: Boolean, 
		wait_for_active_shards: WaitForActiveShards, 
		wait_for_completion: Boolean
	)
	@JsonCodec case class Body(
		max_docs: Long, 
		query: QueryContainer, 
		slice: SlicedScroll
	)
}

