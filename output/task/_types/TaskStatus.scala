package com.converted.elasticsearch.task._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ float, long }
import com.converted.elasticsearch._types.Retries.{ Retries }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Status(
	batches: long, 
	canceled: String, 
	created: long, 
	deleted: long, 
	noops: long, 
	failures: Array(String), 
	requests_per_second: float, 
	retries: Retries, 
	throttled: Time, 
	throttled_millis: long, 
	throttled_until: Time, 
	throttled_until_millis: long, 
	timed_out: Boolean, 
	took: long, 
	total: long, 
	updated: long, 
	version_conflicts: long
)

