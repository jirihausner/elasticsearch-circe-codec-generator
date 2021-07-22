package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class ShardsStats(
	done: Long, 
	failed: Long, 
	finalizing: Long, 
	initializing: Long, 
	started: Long, 
	total: Long
)

