package com.converted.elasticsearch.ml.put_data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.DataframeAnalytics.{ DataframeAnalysisAnalyzedFields, DataframeAnalysisContainer, DataframeAnalyticsDestination, DataframeAnalyticsSource }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id
	)
	@JsonCodec case class Body(
		source: DataframeAnalyticsSource, 
		dest: DataframeAnalyticsDestination, 
		analysis: DataframeAnalysisContainer, 
		description: String, 
		model_memory_limit: String, 
		max_num_threads: integer, 
		analyzed_fields: DataframeAnalysisAnalyzedFields, 
		allow_lazy_start: Boolean
	)
}

