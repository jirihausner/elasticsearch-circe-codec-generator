package com.converted.elasticsearch.ml.explain_data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.DataframeAnalytics.{ DataframeAnalyticsFieldSelection, DataframeAnalyticsMemoryEstimation }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		field_selection: Array[DataframeAnalyticsFieldSelection], 
		memory_estimation: DataframeAnalyticsMemoryEstimation
	)
}

