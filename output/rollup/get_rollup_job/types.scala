package com.converted.elasticsearch.rollup.get_rollup_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._rollup._types.Groupings.{ Groupings }
import com.converted.elasticsearch._rollup._types.Metric.{ FieldMetric }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Id, IndexName }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time }

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
	metrics: Array(FieldMetric), 
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
	current_position: Dictionary(String, UserDefinedValue), 
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

