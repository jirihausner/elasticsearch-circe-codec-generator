package com.converted.elasticsearch.ml.estimate_model_memory

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Analysis.{ AnalysisConfig }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Request(
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class Body(
		analysis_config: AnalysisConfig, 
		max_bucket_cardinality: Dictionary(Field, long), 
		overall_cardinality: Dictionary(Field, long)
	)
}

