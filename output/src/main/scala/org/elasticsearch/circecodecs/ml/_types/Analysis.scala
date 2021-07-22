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

package org.elasticsearch.circecodecs.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.common.{ Field }
import org.elasticsearch.circecodecs._types.Numeric.{ long }
import org.elasticsearch.circecodecs._types.Time.{ Time, TimeSpan }
import org.elasticsearch.circecodecs.ml._types.{ Detector }
import org.elasticsearch.circecodecs._types.analysis.char_filters.{ CharFilter }
import org.elasticsearch.circecodecs._types.analysis.tokenizers.{ Tokenizer }
import org.elasticsearch.circecodecs._types.analysis.token_filters.{ TokenFilter }

@JsonCodec case class AnalysisConfig(
	bucket_span: TimeSpan, 
	categorization_field_name: Field, 
	categorization_filters: Seq[String], 
	detectors: Seq[Detector], 
	influencers: Seq[Field], 
	latency: Time, 
	multivariate_by_fields: Boolean, 
	per_partition_categorization: PerPartitionCategorization, 
	summary_count_field_name: Field, 
	categorization_analyzer: CategorizationAnalyzer | String
)

@JsonCodec case class PerPartitionCategorization(
	enabled: Boolean, 
	stop_on_warn: Boolean
)

@JsonCodec case class AnalysisLimits(
	categorization_examples_limit: long, 
	model_memory_limit: String
)

@JsonCodec case class AnalysisMemoryLimit(
	model_memory_limit: String
)

@JsonCodec case class CategorizationAnalyzer(
	filter: Seq[String | TokenFilter], 
	tokenizer: String | Tokenizer, 
	char_filter: Seq[String | CharFilter]
)
