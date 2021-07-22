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
	failures: Array(ShardFailure), 
	skipped: uint
)


@JsonCodec case class BulkStats(
	total_operations: Long, 
	total_time: String, 
	total_time_in_millis: Long, 
	total_size: ByteSize, 
	total_size_in_bytes: Long, 
	avg_time: String, 
	avg_time_in_millis: Long, 
	avg_size: ByteSize, 
	avg_size_in_bytes: Long
)


@JsonCodec case class CompletionStats(
	size_in_bytes: Long, 
	size: ByteSize, 
	fields: Dictionary(Field, FieldSizeUsage)
)


@JsonCodec case class FieldSizeUsage(
	size: ByteSize, 
	size_in_bytes: Long
)


@JsonCodec case class DocStats(
	count: Long, 
	deleted: Long
)


@JsonCodec case class FielddataStats(
	evictions: Long, 
	memory_size: ByteSize, 
	memory_size_in_bytes: Long, 
	fields: Dictionary(Field, FieldMemoryUsage)
)


@JsonCodec case class FieldMemoryUsage(
	memory_size: ByteSize, 
	memory_size_in_bytes: Long
)


@JsonCodec case class FlushStats(
	periodic: Long, 
	total: Long, 
	total_time: String, 
	total_time_in_millis: Long
)


@JsonCodec case class GetStats(
	current: Long, 
	exists_time: String, 
	exists_time_in_millis: Long, 
	exists_total: Long, 
	missing_time: String, 
	missing_time_in_millis: Long, 
	missing_total: Long, 
	time: String, 
	time_in_millis: Long, 
	total: Long
)


@JsonCodec case class IndexingStats(
	index_current: Long, 
	delete_current: Long, 
	delete_time: String, 
	delete_time_in_millis: Long, 
	delete_total: Long, 
	is_throttled: Boolean, 
	noop_update_total: Long, 
	throttle_time: String, 
	throttle_time_in_millis: Long, 
	index_time: String, 
	index_time_in_millis: Long, 
	index_total: Long, 
	index_failed: Long, 
	types: Dictionary(String, IndexingStats)
)


@JsonCodec case class MergesStats(
	current: Long, 
	current_docs: Long, 
	current_size: String, 
	current_size_in_bytes: Long, 
	total: Long, 
	total_auto_throttle: String, 
	total_auto_throttle_in_bytes: Long, 
	total_docs: Long, 
	total_size: String, 
	total_size_in_bytes: Long, 
	total_stopped_time: String, 
	total_stopped_time_in_millis: Long, 
	total_throttled_time: String, 
	total_throttled_time_in_millis: Long, 
	total_time: String, 
	total_time_in_millis: Long
)


@JsonCodec case class PluginStats(
	classname: String, 
	description: String, 
	elasticsearch_version: VersionString, 
	extended_plugins: Array(String), 
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
	current_as_source: Long, 
	current_as_target: Long, 
	throttle_time: String, 
	throttle_time_in_millis: Long
)


@JsonCodec case class RefreshStats(
	external_total: Long, 
	external_total_time_in_millis: Long, 
	listeners: Long, 
	total: Long, 
	total_time: String, 
	total_time_in_millis: Long
)


@JsonCodec case class RequestCacheStats(
	evictions: Long, 
	hit_count: Long, 
	memory_size: String, 
	memory_size_in_bytes: Long, 
	miss_count: Long
)


@JsonCodec case class SearchStats(
	fetch_current: Long, 
	fetch_time_in_millis: Long, 
	fetch_total: Long, 
	open_contexts: Long, 
	query_current: Long, 
	query_time_in_millis: Long, 
	query_total: Long, 
	scroll_current: Long, 
	scroll_time_in_millis: Long, 
	scroll_total: Long, 
	suggest_current: Long, 
	suggest_time_in_millis: Long, 
	suggest_total: Long, 
	groups: Dictionary(String, SearchStats)
)


@JsonCodec case class SegmentsStats(
	count: integer, 
	doc_values_memory: ByteSize, 
	doc_values_memory_in_bytes: integer, 
	file_sizes: Dictionary(String, ShardFileSizeInfo), 
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
	earliest_last_modified_age: Long, 
	operations: Long, 
	size: String, 
	size_in_bytes: Long, 
	uncommitted_operations: integer, 
	uncommitted_size: String, 
	uncommitted_size_in_bytes: Long
)


@JsonCodec case class WarmerStats(
	current: Long, 
	total: Long, 
	total_time: String, 
	total_time_in_millis: Long
)

