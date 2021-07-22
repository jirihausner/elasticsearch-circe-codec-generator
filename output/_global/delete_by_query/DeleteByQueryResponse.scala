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
		batches: long, 
		deleted: long, 
		failures: Array[BulkIndexByScrollFailure], 
		noops: long, 
		requests_per_second: float, 
		retries: Retries, 
		slice_id: integer, 
		task: TaskId, 
		throttled_millis: long, 
		throttled_until_millis: long, 
		timed_out: Boolean, 
		took: long, 
		total: long, 
		version_conflicts: long
	)
}

