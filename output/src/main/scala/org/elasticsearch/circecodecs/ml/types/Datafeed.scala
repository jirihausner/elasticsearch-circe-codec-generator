/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.circecodecs.ml.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.aggregations.AggregationContainer.{ AggregationContainer }
import org.elasticsearch.circecodecs.types.common.{ ExpandWildcards, Id, Indices }
import org.elasticsearch.circecodecs.types.mapping.RuntimeFields.{ RuntimeFields }
import org.elasticsearch.circecodecs.types.Numeric.{ double, integer, long }
import org.elasticsearch.circecodecs.types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs.types.Scripting.{ ScriptField }
import org.elasticsearch.circecodecs.types.Time.{ Time, Timestamp }
import org.elasticsearch.circecodecs.ml.types.{ DiscoveryNode }

@JsonCodec case class Datafeed(
	aggregations: Dictionary[String, AggregationContainer], 
	aggs: Dictionary[String, AggregationContainer], 
	chunking_config: ChunkingConfig, 
	datafeed_id: Id, 
	frequency: Timestamp, 
	indices: Seq[String], 
	indexes: Seq[String], 
	job_id: Id, 
	max_empty_searches: integer, 
	query: QueryContainer, 
	query_delay: Timestamp, 
	script_fields: Dictionary[String, ScriptField], 
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
	bucket_count: long, 
	exponential_average_search_time_per_hour_ms: double, 
	job_id: Id, 
	search_count: long, 
	total_search_time_ms: double, 
	average_search_time_per_bucket_ms: Double
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
