package com.converted.elasticsearch.transform.get_transform_stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Node.{ NodeAttributes }
import com.converted.elasticsearch._types.Numeric.{ double, long }
import com.converted.elasticsearch._types.Time.{ DateString, EpochMillis }

@JsonCodec case class TransformStats(
	checkpointing: Checkpointing, 
	id: Id, 
	node: NodeAttributes, 
	reason: String, 
	state: String, 
	stats: TransformIndexerStats
)


@JsonCodec case class TransformProgress(
	docs_indexed: long, 
	docs_processed: long, 
	docs_remaining: long, 
	percent_complete: double, 
	total_docs: long
)


@JsonCodec case class TransformIndexerStats(
	documents_indexed: long, 
	documents_processed: long, 
	exponential_avg_checkpoint_duration_ms: double, 
	exponential_avg_documents_indexed: double, 
	exponential_avg_documents_processed: double, 
	index_failures: long, 
	index_time_in_ms: long, 
	index_total: long, 
	pages_processed: long, 
	processing_time_in_ms: long, 
	processing_total: long, 
	search_failures: long, 
	search_time_in_ms: long, 
	search_total: long, 
	trigger_count: long
)


@JsonCodec case class CheckpointStats(
	checkpoint: long, 
	checkpoint_progress: TransformProgress, 
	timestamp: DateString, 
	timestamp_millis: EpochMillis, 
	time_upper_bound: DateString, 
	time_upper_bound_millis: EpochMillis
)


@JsonCodec case class Checkpointing(
	changes_last_detected_at: long, 
	changes_last_detected_at_date_time: DateString, 
	last: CheckpointStats, 
	next: CheckpointStats, 
	operations_behind: long
)

