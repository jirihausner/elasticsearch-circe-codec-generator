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

package org.elasticsearch.circecodecs.indices.analyze

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.Numeric.{ long }

@JsonCodec case class AnalyzeDetail(
	analyzer: AnalyzerDetail, 
	charfilters: Seq[CharFilterDetail], 
	custom_analyzer: Boolean, 
	tokenfilters: Seq[TokenDetail], 
	tokenizer: TokenDetail
)

@JsonCodec case class AnalyzerDetail(
	name: String, 
	tokens: Seq[ExplainAnalyzeToken]
)

@JsonCodec case class AnalyzeToken(
	end_offset: long, 
	position: long, 
	position_length: long, 
	start_offset: long, 
	token: String, 
	`type`: String
)

@JsonCodec case class CharFilterDetail(
	filtered_text: Seq[String], 
	name: String
)

@JsonCodec case class ExplainAnalyzeToken(
	bytes: String, 
	end_offset: long, 
	keyword: Boolean, 
	position: long, 
	positionLength: long, 
	start_offset: long, 
	termFrequency: long, 
	token: String, 
	`type`: String
)
type TextToAnalyze = String | Seq[String]

@JsonCodec case class TokenDetail(
	name: String, 
	tokens: Seq[ExplainAnalyzeToken]
)
