package com.converted.elasticsearch.slm.get_stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ EpochMillis }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		retention_deletion_time: String, 
		retention_deletion_time_millis: EpochMillis, 
		retention_failed: Long, 
		retention_runs: Long, 
		retention_timed_out: Long, 
		total_snapshots_deleted: Long, 
		total_snapshot_deletion_failures: Long, 
		total_snapshots_failed: Long, 
		total_snapshots_taken: Long, 
		policy_stats: Array(String)
	)
}

