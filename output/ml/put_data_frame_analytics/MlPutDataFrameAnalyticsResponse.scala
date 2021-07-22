package com.converted.elasticsearch.ml.put_data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.DataframeAnalytics.{ DataframeAnalysisAnalyzedFields, DataframeAnalysisContainer, DataframeAnalyticsDestination, DataframeAnalyticsSource }
import com.converted.elasticsearch._types.common.{ Id, VersionString }
import com.converted.elasticsearch._types.Numeric.{ integer, long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		id: Id, 
		create_time: Long, 
		version: VersionString, 
		source: DataframeAnalyticsSource, 
		description: String, 
		dest: DataframeAnalyticsDestination, 
		model_memory_limit: String, 
		allow_lazy_start: Boolean, 
		max_num_threads: integer, 
		analysis: DataframeAnalysisContainer, 
		analyzed_fields: DataframeAnalysisAnalyzedFields
	)
}

