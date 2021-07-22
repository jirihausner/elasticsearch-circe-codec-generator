package com.converted.elasticsearch.nodes.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Fields, Level, Metrics, NodeIds }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		node_id: NodeIds, 
		metric: Metrics, 
		index_metric: Metrics
	)
	@JsonCodec case class QueryParameters(
		completion_fields: Fields, 
		fielddata_fields: Fields, 
		fields: Fields, 
		groups: Boolean, 
		include_segment_file_sizes: Boolean, 
		level: Level, 
		master_timeout: Time, 
		timeout: Time, 
		types: Array(String), 
		include_unloaded_segments: Boolean
	)
}

