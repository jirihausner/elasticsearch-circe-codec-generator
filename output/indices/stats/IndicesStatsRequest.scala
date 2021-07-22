package com.converted.elasticsearch.indices.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Fields, Indices, Level, Metrics, Types }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		metric: Metrics, 
		index: Indices
	)
	@JsonCodec case class QueryParameters(
		completion_fields: Fields, 
		expand_wildcards: ExpandWildcards, 
		fielddata_fields: Fields, 
		fields: Fields, 
		forbid_closed_indices: Boolean, 
		groups: String | Array(String), 
		include_segment_file_sizes: Boolean, 
		include_unloaded_segments: Boolean, 
		level: Level, 
		types: Types
	)
	@JsonCodec case class Body(
	)
}

