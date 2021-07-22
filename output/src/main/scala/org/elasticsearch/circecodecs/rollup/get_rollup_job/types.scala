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

package org.elasticsearch.circecodecs.rollup.get_rollup_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._rollup._types.Groupings.{ Groupings }
import org.elasticsearch.circecodecs._rollup._types.Metric.{ FieldMetric }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.common.{ Id, IndexName }
import org.elasticsearch.circecodecs._types.Numeric.{ long }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec case class RollupJob(
	config: RollupJobConfiguration, 
	stats: RollupJobStats, 
	status: RollupJobStatus
)

@JsonCodec case class RollupJobConfiguration(
	cron: String, 
	groups: Groupings, 
	id: Id, 
	index_pattern: String, 
	metrics: Seq[FieldMetric], 
	page_size: long, 
	rollup_index: IndexName, 
	timeout: Time
)

@JsonCodec case class RollupJobStats(
	documents_processed: long, 
	index_failures: long, 
	index_time_in_ms: long, 
	index_total: long, 
	pages_processed: long, 
	rollups_indexed: long, 
	search_failures: long, 
	search_time_in_ms: long, 
	search_total: long, 
	trigger_count: long, 
	processing_time_in_ms: long, 
	processing_total: long
)

@JsonCodec case class RollupJobStatus(
	current_position: Dictionary[String, UserDefinedValue], 
	job_state: IndexingJobState, 
	upgraded_doc_id: Boolean
)

object IndexingJobState extends Enumeration {
	type IndexingJobState = Value

	val started = Value(0, "started")
	val indexing = Value(1, "indexing")
	val stopping = Value(2, "stopping")
	val stopped = Value(3, "stopped")
	val aborting = Value(4, "aborting")
}

implicit val indexingJobStateDecoder: Decoder[IndexingJobState.Value] = Decoder.decodeEnumeration(IndexingJobState)
implicit val indexingJobStateEncoder: Encoder[IndexingJobState.Value] = Decoder.encodeEnumeration(IndexingJobState)
