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
	start_time_in_millis: Long, 
	time_in_millis: Long
)


@JsonCodec case class ShardsStatsSummaryItem(
	file_count: Long, 
	size_in_bytes: Long
)

