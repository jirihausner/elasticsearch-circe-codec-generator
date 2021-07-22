package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.indices._types.{ FielddataSettings }
import com.converted.elasticsearch.indices._types.{ IndicesCircuitBreakerSettings }
import com.converted.elasticsearch.indices._types.{ IndicesRecoverySettings }

@JsonCodec case class IndicesModuleSettings(
	circuit_breaker_settings: IndicesCircuitBreakerSettings, 
	fielddata_settings: FielddataSettings, 
	qeueries_cache_size: String, 
	recovery_settings: IndicesRecoverySettings
)
