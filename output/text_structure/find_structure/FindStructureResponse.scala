package com.converted.elasticsearch.text_structure.find_structure

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ingest._types.Pipeline.{ PipelineConfig }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.mapping.TypeMapping.{ TypeMapping }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch.text_structure.find_structure.{ FieldStat }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		charset: String, 
		has_header_row: Boolean, 
		has_byte_order_marker: Boolean, 
		format: String, 
		field_stats: Dictionary[Field, FieldStat], 
		sample_start: String, 
		num_messages_analyzed: integer, 
		mappings: TypeMapping, 
		quote: String, 
		delimiter: String, 
		need_client_timezone: Boolean, 
		num_lines_analyzed: integer, 
		column_names: Seq[String], 
		explanation: Seq[String], 
		grok_pattern: String, 
		multiline_start_pattern: String, 
		exclude_lines_pattern: String, 
		java_timestamp_formats: Seq[String], 
		joda_timestamp_formats: Seq[String], 
		timestamp_field: Field, 
		should_trim_fields: Boolean, 
		ingest_pipeline: PipelineConfig
	)
}

