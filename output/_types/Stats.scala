package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices.stats.types.{ ShardFileSizeInfo }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.{ ByteSize, Field, Name, VersionString }
import com.converted.elasticsearch._types.{ ErrorCause, ShardFailure }
import com.converted.elasticsearch._types.{ integer, long, uint }

@JsonCodec case class ClusterStatistics(
	skipped: integer, 
	successful: integer, 
	total: integer
)

@JsonCodec case class ShardStatistics(
	failed: uint, 
	successful: uint, 
	total: uint, 
	failures: Seq[ShardFailure], 
	skipped: uint
)

@JsonCodec case class BulkStats(
	total_operations: long, 
	total_time: String, 
	total_time_in_millis: long, 
	total_size: ByteSize, 
	total_size_in_bytes: long, 
	avg_time: String, 
	avg_time_in_millis: long, 
	avg_size: ByteSize, 
	avg_size_in_bytes: long
)

@JsonCodec case class CompletionStats(
	size_in_bytes: long, 
	size: ByteSize, 
	fields: Dictionary[Field, FieldSizeUsage]
)

@JsonCodec case class FieldSizeUsage(
	size: ByteSize, 
	size_in_bytes: long
)

@JsonCodec case class DocStats(
	count: long, 
	deleted: long
)

@JsonCodec case class FielddataStats(
	evictions: long, 
	memory_size: ByteSize, 
	memory_size_in_bytes: long, 
	fields: Dictionary[Field, FieldMemoryUsage]
)

@JsonCodec case class FieldMemoryUsage(
	memory_size: ByteSize, 
	memory_size_in_bytes: long
)

@JsonCodec case class FlushStats(
	periodic: long, 
	total: long, 
	total_time: String, 
	total_time_in_millis: long
)

@JsonCodec case class GetStats(
	current: long, 
	exists_time: String, 
	exists_time_in_millis: long, 
	exists_total: long, 
	missing_time: String, 
	missing_time_in_millis: long, 
	missing_total: long, 
	time: String, 
	time_in_millis: long, 
	total: long
)

@JsonCodec case class IndexingStats(
	index_current: long, 
	delete_current: long, 
	delete_time: String, 
	delete_time_in_millis: long, 
	delete_total: long, 
	is_throttled: Boolean, 
	noop_update_total: long, 
	throttle_time: String, 
	throttle_time_in_millis: long, 
	index_time: String, 
	index_time_in_millis: long, 
	index_total: long, 
	index_failed: long, 
	types: Dictionary[String, IndexingStats]
)

@JsonCodec case class MergesStats(
	current: long, 
	current_docs: long, 
	current_size: String, 
	current_size_in_bytes: long, 
	total: long, 
	total_auto_throttle: String, 
	total_auto_throttle_in_bytes: long, 
	total_docs: long, 
	total_size: String, 
	total_size_in_bytes: long, 
	total_stopped_time: String, 
	total_stopped_time_in_millis: long, 
	total_throttled_time: String, 
	total_throttled_time_in_millis: long, 
	total_time: String, 
	total_time_in_millis: long
)

@JsonCodec case class PluginStats(
	classname: String, 
	description: String, 
	elasticsearch_version: VersionString, 
	extended_plugins: Seq[String], 
	has_native_controller: Boolean, 
	java_version: VersionString, 
	name: Name, 
	version: VersionString, 
	licensed: Boolean, 
	`type`: String
)

@JsonCodec case class QueryCacheStats(
	cache_count: integer, 
	cache_size: integer, 
	evictions: integer, 
	hit_count: integer, 
	memory_size: ByteSize, 
	memory_size_in_bytes: integer, 
	miss_count: integer, 
	total_count: integer
)

@JsonCodec case class RecoveryStats(
	current_as_source: long, 
	current_as_target: long, 
	throttle_time: String, 
	throttle_time_in_millis: long
)

@JsonCodec case class RefreshStats(
	external_total: long, 
	external_total_time_in_millis: long, 
	listeners: long, 
	total: long, 
	total_time: String, 
	total_time_in_millis: long
)

@JsonCodec case class RequestCacheStats(
	evictions: long, 
	hit_count: long, 
	memory_size: String, 
	memory_size_in_bytes: long, 
	miss_count: long
)

@JsonCodec case class SearchStats(
	fetch_current: long, 
	fetch_time_in_millis: long, 
	fetch_total: long, 
	open_contexts: long, 
	query_current: long, 
	query_time_in_millis: long, 
	query_total: long, 
	scroll_current: long, 
	scroll_time_in_millis: long, 
	scroll_total: long, 
	suggest_current: long, 
	suggest_time_in_millis: long, 
	suggest_total: long, 
	groups: Dictionary[String, SearchStats]
)

@JsonCodec case class SegmentsStats(
	count: integer, 
	doc_values_memory: ByteSize, 
	doc_values_memory_in_bytes: integer, 
	file_sizes: Dictionary[String, ShardFileSizeInfo], 
	fixed_bit_set: ByteSize, 
	fixed_bit_set_memory_in_bytes: integer, 
	index_writer_memory: ByteSize, 
	index_writer_max_memory_in_bytes: integer, 
	index_writer_memory_in_bytes: integer, 
	max_unsafe_auto_id_timestamp: integer, 
	memory: ByteSize, 
	memory_in_bytes: integer, 
	norms_memory: ByteSize, 
	norms_memory_in_bytes: integer, 
	points_memory: ByteSize, 
	points_memory_in_bytes: integer, 
	stored_memory: ByteSize, 
	stored_fields_memory_in_bytes: integer, 
	terms_memory_in_bytes: integer, 
	terms_memory: ByteSize, 
	term_vectory_memory: ByteSize, 
	term_vectors_memory_in_bytes: integer, 
	version_map_memory: ByteSize, 
	version_map_memory_in_bytes: integer
)

@JsonCodec case class StoreStats(
	size: ByteSize, 
	size_in_bytes: integer, 
	reserved: ByteSize, 
	reserved_in_bytes: integer, 
	total_data_set_size: ByteSize, 
	total_data_set_size_in_bytes: integer
)

@JsonCodec case class TranslogStats(
	earliest_last_modified_age: long, 
	operations: long, 
	size: String, 
	size_in_bytes: long, 
	uncommitted_operations: integer, 
	uncommitted_size: String, 
	uncommitted_size_in_bytes: long
)

@JsonCodec case class WarmerStats(
	current: long, 
	total: long, 
	total_time: String, 
	total_time_in_millis: long
)
