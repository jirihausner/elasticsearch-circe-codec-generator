package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch.snapshot._types.{ ShardsStatsStage }

@JsonCodec case class SnapshotShardsStatus(
	stage: ShardsStatsStage, 
	stats: ShardsStatsSummary
)

@JsonCodec case class ShardsStatsSummary(
	incremental: ShardsStatsSummaryItem, 
	total: ShardsStatsSummaryItem, 
	start_time_in_millis: long, 
	time_in_millis: long
)

@JsonCodec case class ShardsStatsSummaryItem(
	file_count: long, 
	size_in_bytes: long
)
