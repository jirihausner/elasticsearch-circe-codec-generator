package com.converted.elasticsearch.ml.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Analysis.{ CategorizationAnalyzer }
import com.converted.elasticsearch._types.common.{ VersionString }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Defaults(
	anomaly_detectors: AnomalyDetectors, 
	datafeeds: Datafeeds
)

@JsonCodec case class NativeCode(
	build_hash: String, 
	version: VersionString
)

@JsonCodec case class Limits(
	max_model_memory_limit: String, 
	effective_max_model_memory_limit: String, 
	total_ml_memory: String
)

@JsonCodec case class Datafeeds(
	scroll_size: integer
)

@JsonCodec case class AnomalyDetectors(
	categorization_analyzer: CategorizationAnalyzer, 
	categorization_examples_limit: integer, 
	model_memory_limit: String, 
	model_snapshot_retention_days: integer, 
	daily_model_snapshot_retention_after_days: integer
)
