package com.converted.elasticsearch.ml.get_data_frame_analytics_stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.DataframeAnalytics.{ DataframeAnalytics }
import com.converted.elasticsearch._ml._types.Dataframe.{ DataframeState }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		count: long, 
		data_frame_analytics: Array[DataframeAnalytics]
	)
}

