package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class ShardsStats(
	done: long, 
	failed: long, 
	finalizing: long, 
	initializing: long, 
	started: long, 
	total: long
)

