package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field, Name }
import com.converted.elasticsearch._types.Numeric.{ double, integer }
import com.converted.elasticsearch._types.Time.{ EpochMillis, Time }

@JsonCodec case class Anomaly(
	actual: Seq[double], 
	bucket_span: Time, 
	by_field_name: String, 
	by_field_value: String, 
	causes: Seq[AnomalyCause], 
	detector_index: integer, 
	field_name: String, 
	function: String, 
	function_description: String, 
	influencers: Seq[Influence], 
	initial_record_score: double, 
	is_interim: Boolean, 
	job_id: String, 
	over_field_name: String, 
	over_field_value: String, 
	partition_field_name: String, 
	partition_field_value: String, 
	probability: double, 
	record_score: double, 
	result_type: String, 
	timestamp: EpochMillis, 
	typical: Seq[double]
)

@JsonCodec case class AnomalyCause(
	actual: Seq[double], 
	by_field_name: Name, 
	by_field_value: String, 
	correlated_by_field_value: String, 
	field_name: Field, 
	function: String, 
	function_description: String, 
	influencers: Seq[Influence], 
	over_field_name: Name, 
	over_field_value: String, 
	partition_field_name: String, 
	partition_field_value: String, 
	probability: double, 
	typical: Seq[double]
)

@JsonCodec case class Influence(
	influencer_field_name: String, 
	influencer_field_values: Seq[String]
)
