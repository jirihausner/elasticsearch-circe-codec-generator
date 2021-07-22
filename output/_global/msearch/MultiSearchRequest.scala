package com.converted.elasticsearch._global.msearch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Indices, SearchType, Types }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._global.msearch.{ Body, Header }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Array(Header | Body)
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		`type`: Types
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		ccs_minimize_roundtrips: Boolean, 
		expand_wildcards: ExpandWildcards, 
		ignore_throttled: Boolean, 
		ignore_unavailable: Boolean, 
		max_concurrent_searches: long, 
		max_concurrent_shard_requests: long, 
		pre_filter_shard_size: long, 
		search_type: SearchType, 
		rest_total_hits_as_int: Boolean, 
		typed_keys: Boolean
	)
}

