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
	docs_indexed: Long, 
	docs_processed: Long, 
	docs_remaining: Long, 
	percent_complete: double, 
	total_docs: Long
)


@JsonCodec case class TransformIndexerStats(
	documents_indexed: Long, 
	documents_processed: Long, 
	exponential_avg_checkpoint_duration_ms: double, 
	exponential_avg_documents_indexed: double, 
	exponential_avg_documents_processed: double, 
	index_failures: Long, 
	index_time_in_ms: Long, 
	index_total: Long, 
	pages_processed: Long, 
	processing_time_in_ms: Long, 
	processing_total: Long, 
	search_failures: Long, 
	search_time_in_ms: Long, 
	search_total: Long, 
	trigger_count: Long
)


@JsonCodec case class CheckpointStats(
	checkpoint: Long, 
	checkpoint_progress: TransformProgress, 
	timestamp: DateString, 
	timestamp_millis: EpochMillis, 
	time_upper_bound: DateString, 
	time_upper_bound_millis: EpochMillis
)


@JsonCodec case class Checkpointing(
	changes_last_detected_at: Long, 
	changes_last_detected_at_date_time: DateString, 
	last: CheckpointStats, 
	next: CheckpointStats, 
	operations_behind: Long
)

