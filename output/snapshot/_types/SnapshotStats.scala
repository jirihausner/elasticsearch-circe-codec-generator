package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch.snapshot._types.{ FileCountSnapshotStats }

@JsonCodec case class SnapshotStats(
	incremental: FileCountSnapshotStats, 
	start_time_in_millis: long, 
	time_in_millis: long, 
	total: FileCountSnapshotStats
)

