package com.converted.elasticsearch.rollup.get_rollup_index_capabilities

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field, Id, IndexName }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class IndexCapabilities(
	rollup_jobs: Array(RollupJobSummary)
)


@JsonCodec case class RollupJobSummary(
	fields: Dictionary(Field, Array(RollupJobSummaryField)), 
	index_pattern: String, 
	job_id: Id, 
	rollup_index: IndexName
)


@JsonCodec case class RollupJobSummaryField(
	agg: String, 
	time_zone: String, 
	calendar_interval: Time
)

