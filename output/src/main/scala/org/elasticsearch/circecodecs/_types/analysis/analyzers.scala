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

package org.elasticsearch.circecodecs._types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.common.{ VersionString }
import org.elasticsearch.circecodecs._types.Numeric.{ integer }
import org.elasticsearch.circecodecs._types.analysis.{ Language, SnowballLanguage }
import org.elasticsearch.circecodecs._types.analysis.{ StopWords }
import org.elasticsearch.circecodecs._types.analysis.{ NoriDecompoundMode }

@JsonCodec case class AnalyzerBase(
	`type`: String, 
	version: VersionString
)

@JsonCodec case class CustomAnalyzer(
	char_filter: Seq[String], 
	filter: Seq[String], 
	position_increment_gap: integer, 
	position_offset_gap: integer, 
	tokenizer: String
) extends AnalyzerBase

@JsonCodec case class FingerprintAnalyzer(
	max_output_size: integer, 
	preserve_original: Boolean, 
	separator: String, 
	stopwords: StopWords, 
	stopwords_path: String
) extends AnalyzerBase

@JsonCodec case class KeywordAnalyzer extends AnalyzerBase

@JsonCodec case class LanguageAnalyzer(
	language: Language, 
	stem_exclusion: Seq[String], 
	stopwords: StopWords, 
	stopwords_path: String, 
	`type`: String
) extends AnalyzerBase

@JsonCodec case class NoriAnalyzer(
	decompound_mode: NoriDecompoundMode, 
	stoptags: Seq[String], 
	user_dictionary: String
) extends AnalyzerBase

@JsonCodec case class PatternAnalyzer(
	flags: String, 
	lowercase: Boolean, 
	pattern: String, 
	stopwords: StopWords
) extends AnalyzerBase

@JsonCodec case class SimpleAnalyzer extends AnalyzerBase

@JsonCodec case class SnowballAnalyzer(
	language: SnowballLanguage, 
	stopwords: StopWords
) extends AnalyzerBase

@JsonCodec case class StandardAnalyzer(
	max_token_length: integer, 
	stopwords: StopWords
) extends AnalyzerBase

@JsonCodec case class StopAnalyzer(
	stopwords: StopWords, 
	stopwords_path: String
) extends AnalyzerBase

@JsonCodec case class WhitespaceAnalyzer extends AnalyzerBase
