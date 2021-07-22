package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ float }

@JsonCodec case class IndicesCircuitBreakerSettings(
	fielddata_limit: String, 
	fielddata_overhead: float, 
	request_limit: String, 
	request_overhead: float, 
	total_limit: String
)
