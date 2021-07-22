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

package org.elasticsearch.circecodecs._global.search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.common.{ Field, Fuzziness, Id, IndexName, Routing, SuggestMode, Type }
import org.elasticsearch.circecodecs._types.Geo.{ Distance }
import org.elasticsearch.circecodecs._types.Numeric.{ double, float, integer, long }
import org.elasticsearch.circecodecs._types.query_dsl.geo.{ GeoLocation }

@JsonCodec case class Suggest[T](
	length: integer, 
	offset: integer, 
	options: Seq[SuggestOption[T]], 
	text: String
)

@JsonCodec case class SuggestContainer(
	completion: CompletionSuggester, 
	phrase: PhraseSuggester, 
	prefix: String, 
	regex: String, 
	term: TermSuggester, 
	text: String
)

@JsonCodec case class SuggesterBase(
	field: Field, 
	analyzer: String, 
	size: integer
)
type SuggestOption[TDocument]  = CompletionSuggestOption[TDocument] | PhraseSuggestOption | TermSuggestOption

@JsonCodec case class CompletionSuggestOption[TDocument](
	collate_match: Boolean, 
	contexts: Dictionary[String, Seq[Context]], 
	fields: Dictionary[String, UserDefinedValue], 
	_id: String, 
	_index: IndexName, 
	_type: Type, 
	_routing: Routing, 
	_score: double, 
	_source: TDocument, 
	text: String
)

@JsonCodec case class PhraseSuggestOption(
	text: String, 
	highlighted: String, 
	score: double
)

@JsonCodec case class TermSuggestOption(
	text: String, 
	freq: long, 
	score: double
)

@JsonCodec case class CompletionSuggester(
	contexts: Dictionary[String, String | Seq[String] | GeoLocation | Seq[SuggestContextQuery]], 
	fuzzy: SuggestFuzziness, 
	prefix: String, 
	regex: String, 
	skip_duplicates: Boolean
) extends SuggesterBase

@JsonCodec case class SuggestFuzziness(
	fuzziness: Fuzziness, 
	min_length: integer, 
	prefix_length: integer, 
	transpositions: Boolean, 
	unicode_aware: Boolean
)
type Context = String | GeoLocation

@JsonCodec case class SuggestContextQuery(
	boost: double, 
	context: Context, 
	neighbours: Seq[Distance] | Seq[integer], 
	precision: Distance | integer, 
	prefix: Boolean
)

@JsonCodec case class DirectGenerator(
	field: Field, 
	max_edits: integer, 
	max_inspections: float, 
	max_term_freq: float, 
	min_doc_freq: float, 
	min_word_length: integer, 
	post_filter: String, 
	pre_filter: String, 
	prefix_length: integer, 
	size: integer, 
	suggest_mode: SuggestMode
)

@JsonCodec case class PhraseSuggestCollate(
	params: Dictionary[String, UserDefinedValue], 
	prune: Boolean, 
	query: PhraseSuggestCollateQuery
)

@JsonCodec case class PhraseSuggestCollateQuery(
	id: Id, 
	source: String
)

@JsonCodec case class PhraseSuggester(
	collate: PhraseSuggestCollate, 
	confidence: double, 
	direct_generator: Seq[DirectGenerator], 
	force_unigrams: Boolean, 
	gram_size: integer, 
	highlight: PhraseSuggestHighlight, 
	max_errors: double, 
	real_word_error_likelihood: double, 
	separator: String, 
	shard_size: integer, 
	smoothing: SmoothingModelContainer, 
	text: String, 
	token_limit: integer
) extends SuggesterBase

@JsonCodec case class PhraseSuggestHighlight(
	post_tag: String, 
	pre_tag: String
)

@JsonCodec case class LaplaceSmoothingModel(
	alpha: double
)

@JsonCodec case class LinearInterpolationSmoothingModel(
	bigram_lambda: double, 
	trigram_lambda: double, 
	unigram_lambda: double
)

@JsonCodec sealed trait SmoothingModel

@JsonCodec case class SmoothingModelContainer(
	laplace: LaplaceSmoothingModel, 
	linear_interpolation: LinearInterpolationSmoothingModel, 
	stupid_backoff: StupidBackoffSmoothingModel
)

@JsonCodec case class StupidBackoffSmoothingModel(
	discount: double
)

object StringDistance extends Enumeration {
	type StringDistance = Value

	val internal = Value(0, "internal")
	val damerau_levenshtein = Value(1, "damerau_levenshtein")
	val levenshtein = Value(2, "levenshtein")
	val jaro_winkler = Value(3, "jaro_winkler")
	val ngram = Value(4, "ngram")
}

implicit val stringDistanceDecoder: Decoder[StringDistance.Value] = Decoder.decodeEnumeration(StringDistance)
implicit val stringDistanceEncoder: Encoder[StringDistance.Value] = Decoder.encodeEnumeration(StringDistance)

object SuggestSort extends Enumeration {
	type SuggestSort = Value

	val score = Value(0, "score")
	val frequency = Value(1, "frequency")
}

implicit val suggestSortDecoder: Decoder[SuggestSort.Value] = Decoder.decodeEnumeration(SuggestSort)
implicit val suggestSortEncoder: Encoder[SuggestSort.Value] = Decoder.encodeEnumeration(SuggestSort)

@JsonCodec case class TermSuggester(
	lowercase_terms: Boolean, 
	max_edits: integer, 
	max_inspections: integer, 
	max_term_freq: float, 
	min_doc_freq: float, 
	min_word_length: integer, 
	prefix_length: integer, 
	shard_size: integer, 
	sort: SuggestSort, 
	string_distance: StringDistance, 
	suggest_mode: SuggestMode, 
	text: String
) extends SuggesterBase
