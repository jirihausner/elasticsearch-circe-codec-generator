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
import org.elasticsearch.circecodecs.types.common.{ Field }
import org.elasticsearch.circecodecs.types.Numeric.{ uint }
import org.elasticsearch.circecodecs.types.Time.{ Time }

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
