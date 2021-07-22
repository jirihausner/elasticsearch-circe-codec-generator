package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, VersionString }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class ModelSnapshot(
	description: String, 
	job_id: Id, 
	latest_record_time_stamp: integer, 
	latest_result_time_stamp: integer, 
	min_version: VersionString, 
	model_size_stats: ModelSizeStats, 
	retain: Boolean, 
	snapshot_doc_count: Long, 
	snapshot_id: Id, 
	timestamp: integer
)


@JsonCodec case class ModelSizeStats(
	bucket_allocation_failures_count: Long, 
	job_id: Id, 
	log_time: Time, 
	memory_status: MemoryStatus, 
	model_bytes: Long, 
	model_bytes_exceeded: Long, 
	model_bytes_memory_limit: Long, 
	peak_model_bytes: Long, 
	assignment_memory_basis: String, 
	result_type: String, 
	total_by_field_count: Long, 
	total_over_field_count: Long, 
	total_partition_field_count: Long, 
	categorization_status: CategorizationStatus, 
	categorized_doc_count: integer, 
	dead_category_count: integer, 
	failed_category_count: integer, 
	frequent_category_count: integer, 
	rare_category_count: integer, 
	total_category_count: integer, 
	timestamp: Long
)


object CategorizationStatus extends Enumeration {
	type CategorizationStatus = Value

val ok = Value(0, "ok")
val warn = Value(1, "warn")
}

implicit val categorizationStatusDecoder: Decoder[CategorizationStatus.Value] = Decoder.decodeEnumeration(CategorizationStatus)
implicit val categorizationStatusEncoder: Encoder[CategorizationStatus.Value] = Decoder.encodeEnumeration(CategorizationStatus)


object MemoryStatus extends Enumeration {
	type MemoryStatus = Value

val ok = Value(0, "ok")
val soft_limit = Value(1, "soft_limit")
val hard_limit = Value(2, "hard_limit")
}

implicit val memoryStatusDecoder: Decoder[MemoryStatus.Value] = Decoder.decodeEnumeration(MemoryStatus)
implicit val memoryStatusEncoder: Encoder[MemoryStatus.Value] = Decoder.encodeEnumeration(MemoryStatus)

