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

package org.elasticsearch.circecodecs.indices.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.indices.types.IndexRouting.{ IndexRouting }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.analysis.char_filters.{ CharFilter }
import org.elasticsearch.circecodecs.types.common.{ Name, PipelineName, Uuid, VersionString }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }
import org.elasticsearch.circecodecs.types.Time.{ DateString, Time }

@JsonCodec case class IndexSettings(
	number_of_shards: integer | String, 
	number_of_replicas: integer | String, 
	number_of_routing_shards: integer, 
	check_on_startup: IndexCheckOnStartup, 
	codec: String, 
	routing_partition_size: integer | String, 
	`soft_deletes.retention_lease.period`: Time, 
	load_fixed_bitset_filters_eagerly: Boolean, 
	hidden: Boolean | String, 
	auto_expand_replicas: String, 
	`search.idle.after`: Time, 
	refresh_interval: Time, 
	max_result_window: integer, 
	max_inner_result_window: integer, 
	max_rescore_window: integer, 
	max_docvalue_fields_search: integer, 
	max_script_fields: integer, 
	max_ngram_diff: integer, 
	max_shingle_diff: integer, 
	blocks: IndexSettingBlocks, 
	max_refresh_listeners: integer, 
	`analyze.max_token_count`: integer, 
	`highlight.max_analyzed_offset`: integer, 
	max_terms_count: integer, 
	max_regex_length: integer, 
	routing: IndexRouting, 
	gc_deletes: Time, 
	default_pipeline: PipelineName, 
	final_pipeline: PipelineName, 
	lifecycle: IndexSettingsLifecycle, 
	provided_name: Name, 
	creation_date: DateString, 
	uuid: Uuid, 
	version: IndexVersioning, 
	verified_before_close: Boolean | String, 
	format: String | integer, 
	max_slices_per_scroll: integer, 
	`translog.durability`: String, 
	`query_string.lenient`: Boolean | String, 
	priority: integer | String, 
	top_metrics_max_size: integer, 
	analysis: IndexSettingsAnalysis
)

@JsonCodec case class IndexSettingBlocks(
	read_only: Boolean, 
	read_only_allow_delete: Boolean, 
	read: Boolean, 
	write: Boolean | String, 
	metadata: Boolean
)

object IndexCheckOnStartup extends Enumeration {
	type IndexCheckOnStartup = Value

	val false = Value(0, "false")
	val checksum = Value(1, "checksum")
	val true = Value(2, "true")
}

implicit val indexCheckOnStartupDecoder: Decoder[IndexCheckOnStartup.Value] = Decoder.decodeEnumeration(IndexCheckOnStartup)
implicit val indexCheckOnStartupEncoder: Encoder[IndexCheckOnStartup.Value] = Decoder.encodeEnumeration(IndexCheckOnStartup)

@JsonCodec case class IndexVersioning(
	created: VersionString
)

@JsonCodec case class IndexSettingsLifecycle(
	name: Name
)

@JsonCodec case class IndexSettingsAnalysis(
	char_filter: Dictionary[String, CharFilter]
)
