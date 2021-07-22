package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ long, ulong }

@JsonCodec case class Category(
	category_id: ulong, 
	examples: Array[String], 
	grok_pattern: String, 
	job_id: Id, 
	max_matching_length: ulong, 
	partition_field_name: String, 
	partition_field_value: String, 
	regex: String, 
	terms: String, 
	num_matches: long, 
	preferred_to_categories: Array[Id], 
	p: String, 
	result_type: String, 
	mlcategory: String
)
