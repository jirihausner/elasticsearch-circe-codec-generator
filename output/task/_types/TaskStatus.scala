package com.converted.elasticsearch.task._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ float, long }
import com.converted.elasticsearch._types.Retries.{ Retries }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Status(
	batches: Long, 
	canceled: String, 
	created: Long, 
	deleted: Long, 
	noops: Long, 
	failures: Array(String), 
	requests_per_second: float, 
	retries: Retries, 
	throttled: Time, 
	throttled_millis: Long, 
	throttled_until: Time, 
	throttled_until_millis: Long, 
	timed_out: Boolean, 
	took: Long, 
	total: Long, 
	updated: Long, 
	version_conflicts: Long
)

