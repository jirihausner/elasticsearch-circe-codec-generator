/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.circecodecs.text_structure.find_structure

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._ingest._types.Pipeline.{ PipelineConfig }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ Field }
import org.elasticsearch.circecodecs._types.mapping.TypeMapping.{ TypeMapping }
import org.elasticsearch.circecodecs._types.Numeric.{ integer }
import org.elasticsearch.circecodecs.text_structure.find_structure.{ FieldStat }

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

