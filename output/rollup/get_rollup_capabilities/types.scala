package com.converted.elasticsearch.rollup.get_rollup_capabilities

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Field }

@JsonCodec case class RollupCapabilities(
	rollup_jobs: Array[RollupCapabilitySummary]
)

@JsonCodec case class RollupCapabilitySummary(
	fields: Dictionary[Field, Dictionary[String, UserDefinedValue]], 
	index_pattern: String, 
	job_id: String, 
	rollup_index: String
)
