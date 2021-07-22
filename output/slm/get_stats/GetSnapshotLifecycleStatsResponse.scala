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
		retention_failed: long, 
		retention_runs: long, 
		retention_timed_out: long, 
		total_snapshots_deleted: long, 
		total_snapshot_deletion_failures: long, 
		total_snapshots_failed: long, 
		total_snapshots_taken: long, 
		policy_stats: Array[String]
	)
}

