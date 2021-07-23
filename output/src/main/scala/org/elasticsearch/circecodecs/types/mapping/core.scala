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

package org.elasticsearch.circecodecs.types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.indices.types.FielddataFrequencyFilter.{ FielddataFrequencyFilter }
import org.elasticsearch.circecodecs.indices.types.NumericFielddata.{ NumericFielddata }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.common.{ Fields, RelationName }
import org.elasticsearch.circecodecs.types.Numeric.{ double, integer }
import org.elasticsearch.circecodecs.types.Time.{ DateString }
import org.elasticsearch.circecodecs.types.mapping.{ NestedProperty, ObjectProperty }
import org.elasticsearch.circecodecs.types.mapping.{ GeoPointProperty, GeoShapeProperty, PointProperty }
import org.elasticsearch.circecodecs.types.mapping.{ PropertyBase }
import org.elasticsearch.circecodecs.types.mapping.{ RangeProperty }
import org.elasticsearch.circecodecs.types.mapping.{ CompletionProperty, GenericProperty, IpProperty, Murmur3HashProperty, ShapeProperty, TokenCountProperty }
import org.elasticsearch.circecodecs.types.mapping.{ TermVectorOption }

@JsonCodec case class CorePropertyBase(
	copy_to: Fields, 
	similarity: String, 
	store: Boolean
) extends PropertyBase
type CoreProperty = ObjectProperty | NestedProperty | SearchAsYouTypeProperty | TextProperty | DocValuesProperty

@JsonCodec case class DocValuesPropertyBase(
	doc_values: Boolean
) extends CorePropertyBase
type DocValuesProperty = BinaryProperty | BooleanProperty | DateProperty | DateNanosProperty | KeywordProperty | NumberProperty | RangeProperty | GeoPointProperty | GeoShapeProperty | CompletionProperty | GenericProperty | IpProperty | Murmur3HashProperty | ShapeProperty | TokenCountProperty | VersionProperty | WildcardProperty | PointProperty

@JsonCodec case class BinaryProperty(
	`type`: "binary""
) extends DocValuesPropertyBase

@JsonCodec case class BooleanProperty(
	boost: double, 
	fielddata: NumericFielddata, 
	index: Boolean, 
	null_value: Boolean, 
	`type`: "boolean""
) extends DocValuesPropertyBase

@JsonCodec case class DateProperty(
	boost: double, 
	fielddata: NumericFielddata, 
	format: String, 
	ignore_malformed: Boolean, 
	index: Boolean, 
	null_value: DateString, 
	precision_step: integer, 
	`type`: "date""
) extends DocValuesPropertyBase

@JsonCodec case class DateNanosProperty(
	boost: double, 
	format: String, 
	ignore_malformed: Boolean, 
	index: Boolean, 
	null_value: DateString, 
	precision_step: integer, 
	`type`: "date_nanos""
) extends DocValuesPropertyBase

@JsonCodec case class JoinProperty(
	relations: Dictionary[RelationName, RelationName | Seq[RelationName]], 
	`type`: "join""
) extends PropertyBase

@JsonCodec case class KeywordProperty(
	boost: double, 
	eager_global_ordinals: Boolean, 
	index: Boolean, 
	index_options: IndexOptions, 
	normalizer: String, 
	norms: Boolean, 
	null_value: String, 
	split_queries_on_whitespace: Boolean, 
	`type`: "keyword""
) extends DocValuesPropertyBase

@JsonCodec case class NumberProperty(
	boost: double, 
	coerce: Boolean, 
	fielddata: NumericFielddata, 
	ignore_malformed: Boolean, 
	index: Boolean, 
	null_value: double, 
	scaling_factor: double, 
	`type`: NumberType
) extends DocValuesPropertyBase

object NumberType extends Enumeration {
	type NumberType = Value

	val float = Value(0, "float")
	val half_float = Value(1, "half_float")
	val scaled_float = Value(2, "scaled_float")
	val double = Value(3, "double")
	val integer = Value(4, "integer")
	val long = Value(5, "long")
	val short = Value(6, "short")
	val byte = Value(7, "byte")
	val unsigned_long = Value(8, "unsigned_long")
}

implicit val numberTypeDecoder: Decoder[NumberType.Value] = Decoder.decodeEnumeration(NumberType)
implicit val numberTypeEncoder: Encoder[NumberType.Value] = Decoder.encodeEnumeration(NumberType)

@JsonCodec case class PercolatorProperty(
	`type`: "percolator""
) extends PropertyBase

@JsonCodec case class RankFeatureProperty(
	positive_score_impact: Boolean, 
	`type`: "rank_feature""
) extends PropertyBase

@JsonCodec case class RankFeaturesProperty(
	`type`: "rank_features""
) extends PropertyBase

@JsonCodec case class SearchAsYouTypeProperty(
	analyzer: String, 
	index: Boolean, 
	index_options: IndexOptions, 
	max_shingle_size: integer, 
	norms: Boolean, 
	search_analyzer: String, 
	search_quote_analyzer: String, 
	term_vector: TermVectorOption, 
	`type`: "search_as_you_type""
) extends CorePropertyBase

object IndexOptions extends Enumeration {
	type IndexOptions = Value

	val docs = Value(0, "docs")
	val freqs = Value(1, "freqs")
	val positions = Value(2, "positions")
	val offsets = Value(3, "offsets")
}

implicit val indexOptionsDecoder: Decoder[IndexOptions.Value] = Decoder.decodeEnumeration(IndexOptions)
implicit val indexOptionsEncoder: Encoder[IndexOptions.Value] = Decoder.encodeEnumeration(IndexOptions)

@JsonCodec case class TextIndexPrefixes(
	max_chars: integer, 
	min_chars: integer
)

@JsonCodec case class TextProperty(
	analyzer: String, 
	boost: double, 
	eager_global_ordinals: Boolean, 
	fielddata: Boolean, 
	fielddata_frequency_filter: FielddataFrequencyFilter, 
	index: Boolean, 
	index_options: IndexOptions, 
	index_phrases: Boolean, 
	index_prefixes: TextIndexPrefixes, 
	norms: Boolean, 
	position_increment_gap: integer, 
	search_analyzer: String, 
	search_quote_analyzer: String, 
	term_vector: TermVectorOption, 
	`type`: "text""
) extends CorePropertyBase

@JsonCodec case class VersionProperty(
	`type`: "version""
) extends DocValuesPropertyBase

@JsonCodec case class WildcardProperty(
	`type`: "wildcard""
) extends DocValuesPropertyBase
