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
		batches: Long, 
		created: Long, 
		deleted: Long, 
		failures: Array(BulkIndexByScrollFailure), 
		noops: Long, 
		retries: Retries, 
		requests_per_second: Long, 
		slice_id: integer, 
		task: TaskId, 
		throttled_millis: EpochMillis, 
		throttled_until_millis: EpochMillis, 
		timed_out: Boolean, 
		took: Time, 
		total: Long, 
		updated: Long, 
		version_conflicts: Long
	)
}

