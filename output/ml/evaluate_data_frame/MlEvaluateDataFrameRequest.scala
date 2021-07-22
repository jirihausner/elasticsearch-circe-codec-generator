package com.converted.elasticsearch.ml.evaluate_data_frame

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.DataframeEvaluation.{ DataframeEvaluationContainer }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class Request(
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class Body(
		evaluation: DataframeEvaluationContainer, 
		index: IndexName, 
		query: QueryContainer
	)
}

