package com.converted.elasticsearch._global.rank_eval

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ double }
import com.converted.elasticsearch._global.rank_eval.{ RankEvalMetricDetail }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		metric_score: double, 
		details: Dictionary[Id, RankEvalMetricDetail], 
		failures: Dictionary[String, UserDefinedValue]
	)
}

