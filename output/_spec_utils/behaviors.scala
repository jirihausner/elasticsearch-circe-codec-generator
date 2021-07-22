package com.converted.elasticsearch._spec_utils

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Names }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec sealed trait AdditionalProperties[TKey, TValue]

@JsonCodec case class CommonQueryParameters(
	error_trace: Boolean, 
	filter_path: String | Array(String), 
	human: Boolean, 
	pretty: Boolean, 
	source_query_string: String
)

@JsonCodec case class CommonCatQueryParameters(
	format: String, 
	h: Names, 
	help: Boolean, 
	local: Boolean, 
	master_timeout: Time, 
	s: Array(String), 
	v: Boolean
)
