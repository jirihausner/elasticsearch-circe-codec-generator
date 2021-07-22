package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Analysis.{ AnalysisConfig, AnalysisLimits }
import com.converted.elasticsearch._ml._types.ModelPlot.{ ModelPlotConfig }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._ml._types.Settings.{ CustomSettings }
import com.converted.elasticsearch._types.common.{ Field, Id, IndexName, VersionString }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.Time.{ DateString, Time }
import com.converted.elasticsearch.ml._types.{ DiscoveryNode }
import com.converted.elasticsearch.ml._types.{ ModelSizeStats }

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
	model_snapshot_retention_days: Long, 
	renormalization_window_days: Long, 
	results_index_name: IndexName, 
	results_retention_days: Long, 
	groups: Array(String), 
	model_plot_config: ModelPlotConfig, 
	custom_settings: CustomSettings, 
	job_version: VersionString, 
	deleting: Boolean, 
	daily_model_snapshot_retention_after_days: Long
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
	bucket_count: Long, 
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
	status: Dictionary(String, Long), 
	total: Long, 
	forecasted_jobs: integer
)


@JsonCodec case class DataCounts(
	bucket_count: Long, 
	earliest_record_timestamp: Long, 
	empty_bucket_count: Long, 
	input_bytes: Long, 
	input_field_count: Long, 
	input_record_count: Long, 
	invalid_date_count: Long, 
	job_id: Id, 
	last_data_time: Long, 
	latest_empty_bucket_timestamp: Long, 
	latest_record_timestamp: Long, 
	latest_sparse_bucket_timestamp: Long, 
	latest_bucket_timestamp: Long, 
	missing_field_count: Long, 
	out_of_order_timestamp_count: Long, 
	processed_field_count: Long, 
	processed_record_count: Long, 
	sparse_bucket_count: Long
)


@JsonCodec case class DataDescription(
	format: String, 
	time_field: Field, 
	time_format: String, 
	field_delimiter: String
)

