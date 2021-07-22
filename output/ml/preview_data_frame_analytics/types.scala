package com.converted.elasticsearch.ml.preview_data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.DataframeAnalytics.{ DataframeAnalysisAnalyzedFields, DataframeAnalysisContainer, DataframeAnalyticsSource }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class DataframePreviewConfig(
	source: DataframeAnalyticsSource, 
	analysis: DataframeAnalysisContainer, 
	model_memory_limit: String, 
	max_num_threads: integer, 
	analyzed_fields: DataframeAnalysisAnalyzedFields
)
