package com.converted.elasticsearch._global.delete_by_query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ TaskId }
import com.converted.elasticsearch._types.Errors.{ BulkIndexByScrollFailure }
import com.converted.elasticsearch._types.Numeric.{ float, integer, long }
import com.converted.elasticsearch._types.Retries.{ Retries }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		batches: Long, 
		deleted: Long, 
		failures: Array(BulkIndexByScrollFailure), 
		noops: Long, 
		requests_per_second: float, 
		retries: Retries, 
		slice_id: integer, 
		task: TaskId, 
		throttled_millis: Long, 
		throttled_until_millis: Long, 
		timed_out: Boolean, 
		took: Long, 
		total: Long, 
		version_conflicts: Long
	)
}

