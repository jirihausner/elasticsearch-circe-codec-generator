package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.aggregations.AggregationContainer.{ AggregationContainer }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Id, Indices }
import com.converted.elasticsearch._types.mapping.RuntimeFields.{ RuntimeFields }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Scripting.{ ScriptField }
import com.converted.elasticsearch._types.Time.{ Time, Timestamp }
import com.converted.elasticsearch.ml._types.{ DiscoveryNode }

@JsonCodec case class Datafeed(
	aggregations: Dictionary(String, AggregationContainer), 
	aggs: Dictionary(String, AggregationContainer), 
	chunking_config: ChunkingConfig, 
	datafeed_id: Id, 
	frequency: Timestamp, 
	indices: Array(String), 
	indexes: Array(String), 
	job_id: Id, 
	max_empty_searches: integer, 
	query: QueryContainer, 
	query_delay: Timestamp, 
	script_fields: Dictionary(String, ScriptField), 
	scroll_size: integer, 
	delayed_data_check_config: DelayedDataCheckConfig, 
	runtime_mappings: RuntimeFields, 
	indices_options: DatafeedIndicesOptions
)


@JsonCodec case class DelayedDataCheckConfig(
	check_window: Time, 
	enabled: Boolean
)


object DatafeedState extends Enumeration {
	type DatafeedState = Value

val started = Value(0, "started")
val stopped = Value(1, "stopped")
val starting = Value(2, "starting")
val stopping = Value(3, "stopping")
}

implicit val datafeedStateDecoder: Decoder[DatafeedState.Value] = Decoder.decodeEnumeration(DatafeedState)
implicit val datafeedStateEncoder: Encoder[DatafeedState.Value] = Decoder.encodeEnumeration(DatafeedState)


@JsonCodec case class DatafeedStats(
	assignment_explanation: String, 
	datafeed_id: Id, 
	node: DiscoveryNode, 
	state: DatafeedState, 
	timing_stats: DatafeedTimingStats
)


@JsonCodec case class DatafeedTimingStats(
	bucket_count: Long, 
	exponential_average_search_time_per_hour_ms: double, 
	job_id: Id, 
	search_count: Long, 
	total_search_time_ms: double, 
	average_search_time_per_bucket_ms: Numeric
)


object ChunkingMode extends Enumeration {
	type ChunkingMode = Value

val auto = Value(0, "auto")
val manual = Value(1, "manual")
val off = Value(2, "off")
}

implicit val chunkingModeDecoder: Decoder[ChunkingMode.Value] = Decoder.decodeEnumeration(ChunkingMode)
implicit val chunkingModeEncoder: Encoder[ChunkingMode.Value] = Decoder.encodeEnumeration(ChunkingMode)


@JsonCodec case class ChunkingConfig(
	mode: ChunkingMode, 
	time_span: Time
)


@JsonCodec case class DatafeedIndicesOptions(
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	ignore_throttled: Boolean
)

