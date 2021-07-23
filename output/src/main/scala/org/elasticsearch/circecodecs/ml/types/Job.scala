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
import org.elasticsearch.circecodecs.ml.types.Analysis.{ AnalysisConfig, AnalysisLimits }
import org.elasticsearch.circecodecs.ml.types.ModelPlot.{ ModelPlotConfig }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.ml.types.Settings.{ CustomSettings }
import org.elasticsearch.circecodecs.types.common.{ Field, Id, IndexName, VersionString }
import org.elasticsearch.circecodecs.types.Numeric.{ double, integer, long }
import org.elasticsearch.circecodecs.types.Time.{ DateString, Time }
import org.elasticsearch.circecodecs.ml.types.{ DiscoveryNode }
import org.elasticsearch.circecodecs.ml.types.{ ModelSizeStats }

object JobState extends Enumeration {
	type JobState = Value

	val closing = Value(0, "closing")
	val closed = Value(1, "closed")
	val opened = Value(2, "opened")
	val failed = Value(3, "failed")
	val opening = Value(4, "opening")
}

implicit val jobStateDecoder: Decoder[JobState.Value] = Decoder.decodeEnumeration(JobState)
implicit val jobStateEncoder: Encoder[JobState.Value] = Decoder.encodeEnumeration(JobState)

@JsonCodec case class JobStatistics(
	avg: double, 
	max: double, 
	min: double, 
	total: double
)

@JsonCodec case class Job(
	allow_lazy_open: Boolean, 
	analysis_config: AnalysisConfig, 
	analysis_limits: AnalysisLimits, 
	background_persist_interval: Time, 
	create_time: integer, 
	data_description: DataDescription, 
	description: String, 
	finished_time: integer, 
	job_id: Id, 
	job_type: String, 
	model_snapshot_id: Id, 
	model_snapshot_retention_days: long, 
	renormalization_window_days: long, 
	results_index_name: IndexName, 
	results_retention_days: long, 
	groups: Seq[String], 
	model_plot_config: ModelPlotConfig, 
	custom_settings: CustomSettings, 
	job_version: VersionString, 
	deleting: Boolean, 
	daily_model_snapshot_retention_after_days: long
)

@JsonCodec case class JobStats(
	assignment_explanation: String, 
	data_counts: DataCounts, 
	forecasts_stats: JobForecastStatistics, 
	job_id: String, 
	model_size_stats: ModelSizeStats, 
	node: DiscoveryNode, 
	open_time: DateString, 
	state: JobState, 
	timing_stats: JobTimingStats, 
	deleting: Boolean
)

@JsonCodec case class JobTimingStats(
	average_bucket_processing_time_ms: double, 
	bucket_count: long, 
	exponential_average_bucket_processing_time_ms: double, 
	exponential_average_bucket_processing_time_per_hour_ms: double, 
	job_id: Id, 
	total_bucket_processing_time_ms: double, 
	maximum_bucket_processing_time_ms: double, 
	minimum_bucket_processing_time_ms: double
)

@JsonCodec case class JobForecastStatistics(
	memory_bytes: JobStatistics, 
	processing_time_ms: JobStatistics, 
	records: JobStatistics, 
	status: Dictionary[String, long], 
	total: long, 
	forecasted_jobs: integer
)

@JsonCodec case class DataCounts(
	bucket_count: long, 
	earliest_record_timestamp: long, 
	empty_bucket_count: long, 
	input_bytes: long, 
	input_field_count: long, 
	input_record_count: long, 
	invalid_date_count: long, 
	job_id: Id, 
	last_data_time: long, 
	latest_empty_bucket_timestamp: long, 
	latest_record_timestamp: long, 
	latest_sparse_bucket_timestamp: long, 
	latest_bucket_timestamp: long, 
	missing_field_count: long, 
	out_of_order_timestamp_count: long, 
	processed_field_count: long, 
	processed_record_count: long, 
	sparse_bucket_count: long
)

@JsonCodec case class DataDescription(
	format: String, 
	time_field: Field, 
	time_format: String, 
	field_delimiter: String
)
