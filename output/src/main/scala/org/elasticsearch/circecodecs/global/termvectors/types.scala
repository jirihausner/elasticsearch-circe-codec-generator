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

package org.elasticsearch.circecodecs.global.termvectors

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.Numeric.{ double, integer, long }

@JsonCodec case class TermVector(
	field_statistics: FieldStatistics, 
	terms: Dictionary[String, Term]
)

@JsonCodec case class FieldStatistics(
	doc_count: integer, 
	sum_doc_freq: long, 
	sum_ttf: long
)

@JsonCodec case class Term(
	doc_freq: integer, 
	score: double, 
	term_freq: integer, 
	tokens: Seq[Token], 
	ttf: integer
)

@JsonCodec case class Token(
	end_offset: integer, 
	payload: String, 
	position: integer, 
	start_offset: integer
)

@JsonCodec case class Filter(
	max_doc_freq: integer, 
	max_num_terms: integer, 
	max_term_freq: integer, 
	max_word_length: integer, 
	min_doc_freq: integer, 
	min_term_freq: integer, 
	min_word_length: integer
)
