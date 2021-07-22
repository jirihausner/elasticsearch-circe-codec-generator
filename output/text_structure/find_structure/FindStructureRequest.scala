package com.converted.elasticsearch.text_structure.find_structure

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Numeric.{ uint }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request[TJsonDocument](
	query_parameters: QueryParameters, 
	body: Seq[TJsonDocument]
)

object Request {
	@JsonCodec case class QueryParameters(
		charset: String, 
		column_names: String, 
		delimiter: String, 
		explain: Boolean, 
		format: String, 
		grok_pattern: String, 
		has_header_row: Boolean, 
		line_merge_size_limit: uint, 
		lines_to_sample: uint, 
		quote: String, 
		should_trim_fields: Boolean, 
		timeout: Time, 
		timestamp_field: Field, 
		timestamp_format: String
	)
}

