package com.converted.elasticsearch.cat.data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.data_frame_analytics.{ DataFrameAnalyticsRecord }

@JsonCodec case class Response(
	body: Seq[DataFrameAnalyticsRecord]
)
