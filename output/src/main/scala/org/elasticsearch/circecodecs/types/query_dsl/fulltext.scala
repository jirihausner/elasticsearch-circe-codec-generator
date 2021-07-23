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

package org.elasticsearch.circecodecs.types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.common.{ Field, Fields, Fuzziness, MinimumShouldMatch, MultiTermQueryRewrite }
import org.elasticsearch.circecodecs.types.Numeric.{ double, float, integer }
import org.elasticsearch.circecodecs.types.Scripting.{ Script }
import org.elasticsearch.circecodecs.types.query_dsl.{ QueryBase }
import org.elasticsearch.circecodecs.types.query_dsl.{ Operator }

@JsonCodec case class CommonTermsQuery(
	analyzer: String, 
	cutoff_frequency: double, 
	high_freq_operator: Operator, 
	low_freq_operator: Operator, 
	minimum_should_match: MinimumShouldMatch, 
	query: String
) extends QueryBase

@JsonCodec case class Intervals(
	filter: IntervalsFilter
)

@JsonCodec case class IntervalsAllOf(
	intervals: Seq[IntervalsContainer], 
	max_gaps: integer, 
	ordered: Boolean, 
	filter: IntervalsFilter
)

@JsonCodec case class IntervalsAnyOf(
	intervals: Seq[IntervalsContainer], 
	filter: IntervalsFilter
)

@JsonCodec case class IntervalsContainer(
	all_of: IntervalsAllOf, 
	any_of: IntervalsAnyOf, 
	fuzzy: IntervalsFuzzy, 
	`match`: IntervalsMatch, 
	prefix: IntervalsPrefix, 
	wildcard: IntervalsWildcard
)

@JsonCodec case class IntervalsFilter(
	after: IntervalsContainer, 
	before: IntervalsContainer, 
	contained_by: IntervalsContainer, 
	containing: IntervalsContainer, 
	not_contained_by: IntervalsContainer, 
	not_containing: IntervalsContainer, 
	not_overlapping: IntervalsContainer, 
	overlapping: IntervalsContainer, 
	script: Script
)

@JsonCodec case class IntervalsFuzzy(
	analyzer: String, 
	fuzziness: Fuzziness, 
	prefix_length: integer, 
	term: String, 
	transpositions: Boolean, 
	use_field: Field
)

@JsonCodec case class IntervalsMatch(
	analyzer: String, 
	max_gaps: integer, 
	ordered: Boolean, 
	query: String, 
	use_field: Field, 
	filter: IntervalsFilter
)

@JsonCodec case class IntervalsPrefix(
	analyzer: String, 
	prefix: String, 
	use_field: Field
)

@JsonCodec case class IntervalsQuery(
	all_of: IntervalsAllOf, 
	any_of: IntervalsAnyOf, 
	fuzzy: IntervalsFuzzy, 
	`match`: IntervalsMatch, 
	prefix: IntervalsPrefix, 
	wildcard: IntervalsWildcard
) extends QueryBase

@JsonCodec case class IntervalsWildcard(
	analyzer: String, 
	pattern: String, 
	use_field: Field
)

@JsonCodec case class MatchQuery(
	analyzer: String, 
	auto_generate_synonyms_phrase_query: Boolean, 
	cutoff_frequency: double, 
	fuzziness: Fuzziness, 
	fuzzy_rewrite: MultiTermQueryRewrite, 
	fuzzy_transpositions: Boolean, 
	lenient: Boolean, 
	max_expansions: integer, 
	minimum_should_match: MinimumShouldMatch, 
	operator: Operator, 
	prefix_length: integer, 
	query: String | float | Boolean, 
	zero_terms_query: ZeroTermsQuery
) extends QueryBase

@JsonCodec case class MatchBoolPrefixQuery(
	analyzer: String, 
	fuzziness: Fuzziness, 
	fuzzy_rewrite: MultiTermQueryRewrite, 
	fuzzy_transpositions: Boolean, 
	max_expansions: integer, 
	minimum_should_match: MinimumShouldMatch, 
	operator: Operator, 
	prefix_length: integer, 
	query: String
) extends QueryBase

@JsonCodec case class MatchPhraseQuery(
	analyzer: String, 
	query: String, 
	slop: integer
) extends QueryBase

@JsonCodec case class MatchPhrasePrefixQuery(
	analyzer: String, 
	max_expansions: integer, 
	query: String, 
	slop: integer, 
	zero_terms_query: ZeroTermsQuery
) extends QueryBase

@JsonCodec case class MultiMatchQuery(
	analyzer: String, 
	auto_generate_synonyms_phrase_query: Boolean, 
	cutoff_frequency: double, 
	fields: Fields, 
	fuzziness: Fuzziness, 
	fuzzy_rewrite: MultiTermQueryRewrite, 
	fuzzy_transpositions: Boolean, 
	lenient: Boolean, 
	max_expansions: integer, 
	minimum_should_match: MinimumShouldMatch, 
	operator: Operator, 
	prefix_length: integer, 
	query: String, 
	slop: integer, 
	tie_breaker: double, 
	`type`: TextQueryType, 
	use_dis_max: Boolean, 
	zero_terms_query: ZeroTermsQuery
) extends QueryBase

object TextQueryType extends Enumeration {
	type TextQueryType = Value

	val best_fields = Value(0, "best_fields")
	val most_fields = Value(1, "most_fields")
	val cross_fields = Value(2, "cross_fields")
	val phrase = Value(3, "phrase")
	val phrase_prefix = Value(4, "phrase_prefix")
	val bool_prefix = Value(5, "bool_prefix")
}

implicit val textQueryTypeDecoder: Decoder[TextQueryType.Value] = Decoder.decodeEnumeration(TextQueryType)
implicit val textQueryTypeEncoder: Encoder[TextQueryType.Value] = Decoder.encodeEnumeration(TextQueryType)

object ZeroTermsQuery extends Enumeration {
	type ZeroTermsQuery = Value

	val all = Value(0, "all")
	val none = Value(1, "none")
}

implicit val zeroTermsQueryDecoder: Decoder[ZeroTermsQuery.Value] = Decoder.decodeEnumeration(ZeroTermsQuery)
implicit val zeroTermsQueryEncoder: Encoder[ZeroTermsQuery.Value] = Decoder.encodeEnumeration(ZeroTermsQuery)

@JsonCodec case class QueryStringQuery(
	allow_leading_wildcard: Boolean, 
	analyzer: String, 
	analyze_wildcard: Boolean, 
	auto_generate_synonyms_phrase_query: Boolean, 
	default_field: Field, 
	default_operator: Operator, 
	enable_position_increments: Boolean, 
	escape: Boolean, 
	fields: Fields, 
	fuzziness: Fuzziness, 
	fuzzy_max_expansions: integer, 
	fuzzy_prefix_length: integer, 
	fuzzy_rewrite: MultiTermQueryRewrite, 
	fuzzy_transpositions: Boolean, 
	lenient: Boolean, 
	max_determinized_states: integer, 
	minimum_should_match: MinimumShouldMatch, 
	phrase_slop: double, 
	query: String, 
	quote_analyzer: String, 
	quote_field_suffix: String, 
	rewrite: MultiTermQueryRewrite, 
	tie_breaker: double, 
	time_zone: String, 
	`type`: TextQueryType
) extends QueryBase

object SimpleQueryStringFlags extends Enumeration {
	type SimpleQueryStringFlags = Value

	val nONE = Value(1, "NONE")
	val aND = Value(2, "AND")
	val oR = Value(4, "OR")
	val nOT = Value(8, "NOT")
	val pREFIX = Value(16, "PREFIX")
	val pHRASE = Value(32, "PHRASE")
	val pRECEDENCE = Value(64, "PRECEDENCE")
	val eSCAPE = Value(128, "ESCAPE")
	val wHITESPACE = Value(256, "WHITESPACE")
	val fUZZY = Value(512, "FUZZY")
	val nEAR = Value(1024, "NEAR")
	val sLOP = Value(2048, "SLOP")
	val aLL = Value(4096, "ALL")
}

implicit val simpleQueryStringFlagsDecoder: Decoder[SimpleQueryStringFlags.Value] = Decoder.decodeEnumeration(SimpleQueryStringFlags)
implicit val simpleQueryStringFlagsEncoder: Encoder[SimpleQueryStringFlags.Value] = Decoder.encodeEnumeration(SimpleQueryStringFlags)

@JsonCodec case class SimpleQueryStringQuery(
	analyzer: String, 
	analyze_wildcard: Boolean, 
	auto_generate_synonyms_phrase_query: Boolean, 
	default_operator: Operator, 
	fields: Fields, 
	flags: SimpleQueryStringFlags | String, 
	fuzzy_max_expansions: integer, 
	fuzzy_prefix_length: integer, 
	fuzzy_transpositions: Boolean, 
	lenient: Boolean, 
	minimum_should_match: MinimumShouldMatch, 
	query: String, 
	quote_field_suffix: String
) extends QueryBase
