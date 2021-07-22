package com.converted.elasticsearch._global.reindex

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ TaskId }
import com.converted.elasticsearch._types.Errors.{ BulkIndexByScrollFailure }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Retries.{ Retries }
import com.converted.elasticsearch._types.Time.{ EpochMillis, Time }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		batches: long, 
		created: long, 
		deleted: long, 
		failures: Seq[BulkIndexByScrollFailure], 
		noops: long, 
		retries: Retries, 
		requests_per_second: long, 
		slice_id: integer, 
		task: TaskId, 
		throttled_millis: EpochMillis, 
		throttled_until_millis: EpochMillis, 
		timed_out: Boolean, 
		took: Time, 
		total: long, 
		updated: long, 
		version_conflicts: long
	)
}

