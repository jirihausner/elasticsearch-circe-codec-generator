package com.converted.elasticsearch.ilm.explain_lifecycle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ IndexName, Name, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Time.{ EpochMillis, Time }

@JsonCodec case class LifecycleExplain(
	action: Name, 
	action_time_millis: EpochMillis, 
	age: Time, 
	failed_step: Name, 
	failed_step_retry_count: integer, 
	index: IndexName, 
	is_auto_retryable_error: Boolean, 
	lifecycle_date_millis: EpochMillis, 
	managed: Boolean, 
	phase: Name, 
	phase_time_millis: EpochMillis, 
	policy: Name, 
	step: Name, 
	step_info: Dictionary(String, UserDefinedValue), 
	step_time_millis: EpochMillis, 
	phase_execution: LifecycleExplainPhaseExecution
)

@JsonCodec case class LifecycleExplainPhaseExecution(
	policy: Name, 
	version: VersionNumber, 
	modified_date_in_millis: EpochMillis
)

@JsonCodec case class LifecycleExplainProject(
	project: LifecycleExplainProjectSummary
)

@JsonCodec case class LifecycleExplainProjectSummary(
	index: IndexName, 
	managed: Boolean
)
