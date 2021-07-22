package com.converted.elasticsearch.ccr._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ ByteSize, SequenceNumber, VersionNumber, IndexName }
import com.converted.elasticsearch._types.Errors.{ ErrorCause }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Time.{ EpochMillis }

@JsonCodec case class FollowIndexStats(
	index: IndexName, 
	shards: Array(ShardStats)
)

@JsonCodec case class ShardStats(
	bytes_read: long, 
	failed_read_requests: long, 
	failed_write_requests: long, 
	fatal_exception: ErrorCause, 
	follower_aliases_version: VersionNumber, 
	follower_global_checkpoint: long, 
	follower_index: String, 
	follower_mapping_version: VersionNumber, 
	follower_max_seq_no: SequenceNumber, 
	follower_settings_version: VersionNumber, 
	last_requested_seq_no: SequenceNumber, 
	leader_global_checkpoint: long, 
	leader_index: String, 
	leader_max_seq_no: SequenceNumber, 
	operations_read: long, 
	operations_written: long, 
	outstanding_read_requests: integer, 
	outstanding_write_requests: integer, 
	read_exceptions: Array(ReadException), 
	remote_cluster: String, 
	shard_id: integer, 
	successful_read_requests: long, 
	successful_write_requests: long, 
	time_since_last_read_millis: EpochMillis, 
	total_read_remote_exec_time_millis: EpochMillis, 
	total_read_time_millis: EpochMillis, 
	total_write_time_millis: EpochMillis, 
	write_buffer_operation_count: long, 
	write_buffer_size_in_bytes: ByteSize
)

@JsonCodec case class ReadException(
	exception: ErrorCause, 
	from_seq_no: SequenceNumber, 
	retries: integer
)
