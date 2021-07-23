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

package org.elasticsearch.circecodecs.cat.jobs

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.ml.types.Job.{ JobState }
import org.elasticsearch.circecodecs.ml.types.Model.{ CategorizationStatus, MemoryStatus }
import org.elasticsearch.circecodecs.types.common.{ ByteSize, Id, NodeId }

@JsonCodec case class JobsRecord(
	id: Id, 
	state: JobState, 
	opened_time: String, 
	assignment_explanation: String, 
	`data.processed_records`: String, 
	`data.processed_fields`: String, 
	`data.input_bytes`: ByteSize, 
	`data.input_records`: String, 
	`data.input_fields`: String, 
	`data.invalid_dates`: String, 
	`data.missing_fields`: String, 
	`data.out_of_order_timestamps`: String, 
	`data.empty_buckets`: String, 
	`data.sparse_buckets`: String, 
	`data.buckets`: String, 
	`data.earliest_record`: String, 
	`data.latest_record`: String, 
	`data.last`: String, 
	`data.last_empty_bucket`: String, 
	`data.last_sparse_bucket`: String, 
	`model.bytes`: ByteSize, 
	`model.memory_status`: MemoryStatus, 
	`model.bytes_exceeded`: ByteSize, 
	`model.memory_limit`: String, 
	`model.by_fields`: String, 
	`model.over_fields`: String, 
	`model.partition_fields`: String, 
	`model.bucket_allocation_failures`: String, 
	`model.categorization_status`: CategorizationStatus, 
	`model.categorized_doc_count`: String, 
	`model.total_category_count`: String, 
	`model.frequent_category_count`: String, 
	`model.rare_category_count`: String, 
	`model.dead_category_count`: String, 
	`model.failed_category_count`: String, 
	`model.log_time`: String, 
	`model.timestamp`: String, 
	`forecasts.total`: String, 
	`forecasts.memory.min`: String, 
	`forecasts.memory.max`: String, 
	`forecasts.memory.avg`: String, 
	`forecasts.memory.total`: String, 
	`forecasts.records.min`: String, 
	`forecasts.records.max`: String, 
	`forecasts.records.avg`: String, 
	`forecasts.records.total`: String, 
	`forecasts.time.min`: String, 
	`forecasts.time.max`: String, 
	`forecasts.time.avg`: String, 
	`forecasts.time.total`: String, 
	`node.id`: NodeId, 
	`node.name`: String, 
	`node.ephemeral_id`: NodeId, 
	`node.address`: String, 
	`buckets.count`: String, 
	`buckets.time.total`: String, 
	`buckets.time.min`: String, 
	`buckets.time.max`: String, 
	`buckets.time.exp_avg`: String, 
	`buckets.time.exp_avg_hour`: String
)
