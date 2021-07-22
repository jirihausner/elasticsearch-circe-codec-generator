package com.converted.elasticsearch.slm._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._watcher._types.Schedule.{ CronExpression }
import com.converted.elasticsearch._types.common.{ Id, Indices, Name, Uuid, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Time.{ DateString, EpochMillis, Time }

@JsonCodec case class SnapshotLifecycle(
	in_progress: InProgress, 
	last_failure: Invocation, 
	last_success: Invocation, 
	modified_date: DateString, 
	modified_date_millis: EpochMillis, 
	next_execution: DateString, 
	next_execution_millis: EpochMillis, 
	policy: Policy, 
	version: VersionNumber, 
	stats: Statistics
)

@JsonCodec case class Statistics(
	retention_deletion_time: DateString, 
	retention_deletion_time_millis: EpochMillis, 
	retention_failed: long, 
	retention_runs: long, 
	retention_timed_out: long, 
	policy: Id, 
	total_snapshots_deleted: long, 
	total_snapshot_deletion_failures: long, 
	total_snapshots_failed: long, 
	total_snapshots_taken: long
)

@JsonCodec case class Policy(
	config: Configuration, 
	name: Name, 
	repository: String, 
	retention: Retention, 
	schedule: CronExpression
)

@JsonCodec case class Retention(
	expire_after: Time, 
	max_count: integer, 
	min_count: integer
)

@JsonCodec case class Configuration(
	ignore_unavailable: Boolean, 
	include_global_state: Boolean, 
	indices: Indices
)

@JsonCodec case class InProgress(
	name: Name, 
	start_time_millis: DateString, 
	state: String, 
	uuid: Uuid
)

@JsonCodec case class Invocation(
	snapshot_name: Name, 
	time: DateString
)
