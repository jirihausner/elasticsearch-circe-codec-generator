package com.converted.elasticsearch._global.update_by_query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ TaskId }
import com.converted.elasticsearch._types.Errors.{ BulkIndexByScrollFailure }
import com.converted.elasticsearch._types.Numeric.{ float, long, ulong }
import com.converted.elasticsearch._types.Retries.{ Retries }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		batches: long, 
		failures: Array[BulkIndexByScrollFailure], 
		noops: long, 
		deleted: long, 
		requests_per_second: float, 
		retries: Retries, 
		task: TaskId, 
		timed_out: Boolean, 
		took: long, 
		total: long, 
		updated: long, 
		version_conflicts: long, 
		throttled_millis: ulong, 
		throttled_until_millis: ulong
	)
}

