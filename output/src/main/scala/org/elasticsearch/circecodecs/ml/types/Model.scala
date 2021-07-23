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
import org.elasticsearch.circecodecs.types.common.{ Id, VersionString }
import org.elasticsearch.circecodecs.types.Numeric.{ integer, long }
import org.elasticsearch.circecodecs.types.Time.{ Time }

@JsonCodec case class ModelSnapshot(
	description: String, 
	job_id: Id, 
	latest_record_time_stamp: integer, 
	latest_result_time_stamp: integer, 
	min_version: VersionString, 
	model_size_stats: ModelSizeStats, 
	retain: Boolean, 
	snapshot_doc_count: long, 
	snapshot_id: Id, 
	timestamp: integer
)

@JsonCodec case class ModelSizeStats(
	bucket_allocation_failures_count: long, 
	job_id: Id, 
	log_time: Time, 
	memory_status: MemoryStatus, 
	model_bytes: long, 
	model_bytes_exceeded: long, 
	model_bytes_memory_limit: long, 
	peak_model_bytes: long, 
	assignment_memory_basis: String, 
	result_type: String, 
	total_by_field_count: long, 
	total_over_field_count: long, 
	total_partition_field_count: long, 
	categorization_status: CategorizationStatus, 
	categorized_doc_count: integer, 
	dead_category_count: integer, 
	failed_category_count: integer, 
	frequent_category_count: integer, 
	rare_category_count: integer, 
	total_category_count: integer, 
	timestamp: long
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
