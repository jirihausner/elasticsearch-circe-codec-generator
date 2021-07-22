package com.converted.elasticsearch.ml.get_data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.DataframeAnalytics.{ DataframeAnalyticsSummary }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		count: integer, 
		data_frame_analytics: Seq[DataframeAnalyticsSummary]
	)
}

