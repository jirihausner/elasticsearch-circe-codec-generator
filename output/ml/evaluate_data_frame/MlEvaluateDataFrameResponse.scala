package com.converted.elasticsearch.ml.evaluate_data_frame

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.ml.evaluate_data_frame.{ DataframeClassificationSummary, DataframeOutlierDetectionSummary, DataframeRegressionSummary }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		classification: DataframeClassificationSummary, 
		outlier_detection: DataframeOutlierDetectionSummary, 
		regression: DataframeRegressionSummary
	)
}

