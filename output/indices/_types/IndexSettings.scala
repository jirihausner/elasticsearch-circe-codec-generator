package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.IndexRouting.{ IndexRouting }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.analysis.char_filters.{ CharFilter }
import com.converted.elasticsearch._types.common.{ Name, PipelineName, Uuid, VersionString }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Time.{ DateString, Time }

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
	char_filter: Dictionary(String, CharFilter)
)
