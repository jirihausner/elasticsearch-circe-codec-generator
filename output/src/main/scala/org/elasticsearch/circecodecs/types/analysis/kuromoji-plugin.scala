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

package org.elasticsearch.circecodecs.types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.Numeric.{ integer }
import org.elasticsearch.circecodecs.types.analysis.{ AnalyzerBase }
import org.elasticsearch.circecodecs.types.analysis.{ CharFilterBase }
import org.elasticsearch.circecodecs.types.analysis.{ TokenizerBase }
import org.elasticsearch.circecodecs.types.analysis.{ TokenFilterBase }

@JsonCodec case class KuromojiAnalyzer(
	mode: KuromojiTokenizationMode, 
	user_dictionary: String
) extends AnalyzerBase

@JsonCodec case class KuromojiIterationMarkCharFilter(
	normalize_kana: Boolean, 
	normalize_kanji: Boolean
) extends CharFilterBase

@JsonCodec case class KuromojiPartOfSpeechTokenFilter(
	stoptags: Seq[String]
) extends TokenFilterBase

@JsonCodec case class KuromojiReadingFormTokenFilter(
	use_romaji: Boolean
) extends TokenFilterBase

@JsonCodec case class KuromojiStemmerTokenFilter(
	minimum_length: integer
) extends TokenFilterBase

object KuromojiTokenizationMode extends Enumeration {
	type KuromojiTokenizationMode = Value

	val normal = Value(0, "normal")
	val search = Value(1, "search")
	val extended = Value(2, "extended")
}

implicit val kuromojiTokenizationModeDecoder: Decoder[KuromojiTokenizationMode.Value] = Decoder.decodeEnumeration(KuromojiTokenizationMode)
implicit val kuromojiTokenizationModeEncoder: Encoder[KuromojiTokenizationMode.Value] = Decoder.encodeEnumeration(KuromojiTokenizationMode)

@JsonCodec case class KuromojiTokenizer(
	discard_punctuation: Boolean, 
	mode: KuromojiTokenizationMode, 
	nbest_cost: integer, 
	nbest_examples: String, 
	user_dictionary: String, 
	user_dictionary_rules: Seq[String]
) extends TokenizerBase
