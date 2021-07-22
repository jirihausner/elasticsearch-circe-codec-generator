package com.converted.elasticsearch.ml.put_datafeed

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Datafeed.{ ChunkingConfig, DatafeedIndicesOptions, DelayedDataCheckConfig }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.aggregations.AggregationContainer.{ AggregationContainer }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Id, Indices }
import com.converted.elasticsearch._types.mapping.RuntimeFields.{ RuntimeFields }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Scripting.{ ScriptField }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		datafeed_id: Id
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		ignore_throttled: Boolean, 
		ignore_unavailable: Boolean
	)
	@JsonCodec case class Body(
		aggregations: Dictionary(String, AggregationContainer), 
		chunking_config: ChunkingConfig, 
		delayed_data_check_config: DelayedDataCheckConfig, 
		frequency: Time, 
		indices: Array(String), 
		indexes: Array(String), 
		indices_options: DatafeedIndicesOptions, 
		job_id: Id, 
		max_empty_searches: integer, 
		query: QueryContainer, 
		query_delay: Time, 
		runtime_mappings: RuntimeFields, 
		script_fields: Dictionary(String, ScriptField), 
		scroll_size: integer
	)
}

