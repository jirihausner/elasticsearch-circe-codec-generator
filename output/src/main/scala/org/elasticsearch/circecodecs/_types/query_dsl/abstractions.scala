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

package org.elasticsearch.circecodecs._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.behaviors.{ AdditionalProperties }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ SingleKeyDictionary }
import org.elasticsearch.circecodecs._types.common.{ Field, Id, IndexName, Routing }
import org.elasticsearch.circecodecs._types.Numeric.{ float, long }
import org.elasticsearch.circecodecs._types.query_dsl.{ BoolQuery, BoostingQuery, ConstantScoreQuery, DisMaxQuery, FunctionScoreQuery }
import org.elasticsearch.circecodecs._types.query_dsl.{ CommonTermsQuery, IntervalsQuery, MatchBoolPrefixQuery, MatchPhrasePrefixQuery, MatchPhraseQuery, MatchQuery, MultiMatchQuery, QueryStringQuery, SimpleQueryStringQuery }
import org.elasticsearch.circecodecs._types.query_dsl.{ GeoBoundingBoxQuery, GeoDistanceQuery, GeoPolygonQuery, GeoShapeQuery }
import org.elasticsearch.circecodecs._types.query_dsl.{ HasChildQuery, HasParentQuery, NestedQuery, ParentIdQuery }
import org.elasticsearch.circecodecs._types.query_dsl.{ MatchAllQuery }
import org.elasticsearch.circecodecs._types.query_dsl.{ MatchNoneQuery }
import org.elasticsearch.circecodecs._types.query_dsl.{ SpanContainingQuery, SpanFieldMaskingQuery, SpanFirstQuery, SpanMultiTermQuery, SpanNearQuery, SpanNotQuery, SpanOrQuery, SpanTermQuery, SpanWithinQuery }
import org.elasticsearch.circecodecs._types.query_dsl.{ DistanceFeatureQuery, MoreLikeThisQuery, PercolateQuery, PinnedQuery, RankFeatureQuery, ScriptQuery, ScriptScoreQuery, ShapeQuery }
import org.elasticsearch.circecodecs._types.query_dsl.{ ExistsQuery, FuzzyQuery, IdsQuery, PrefixQuery, RangeQuery, RegexpQuery, TermQuery, TermsQuery, TermsSetQuery, TypeQuery, WildcardQuery }

@JsonCodec case class QueryContainer(
	bool: BoolQuery, 
	boosting: BoostingQuery, 
	common: SingleKeyDictionary[Field, CommonTermsQuery | String], 
	combined_fields: CombinedFieldsQuery, 
	constant_score: ConstantScoreQuery, 
	dis_max: DisMaxQuery, 
	distance_feature: SingleKeyDictionary[Field, DistanceFeatureQuery | String] | DistanceFeatureQuery, 
	exists: ExistsQuery, 
	function_score: FunctionScoreQuery, 
	fuzzy: SingleKeyDictionary[Field, FuzzyQuery | String], 
	geo_bounding_box: NamedQuery[GeoBoundingBoxQuery | String], 
	geo_distance: GeoDistanceQuery, 
	geo_polygon: NamedQuery[GeoPolygonQuery | String], 
	geo_shape: NamedQuery[GeoShapeQuery | String], 
	has_child: HasChildQuery, 
	has_parent: HasParentQuery, 
	ids: IdsQuery, 
	intervals: NamedQuery[IntervalsQuery | String], 
	`match`: NamedQuery[MatchQuery | String | float | Boolean], 
	match_all: MatchAllQuery, 
	match_bool_prefix: NamedQuery[MatchBoolPrefixQuery | String], 
	match_none: MatchNoneQuery, 
	match_phrase: NamedQuery[MatchPhraseQuery | String], 
	match_phrase_prefix: NamedQuery[MatchPhrasePrefixQuery | String], 
	more_like_this: MoreLikeThisQuery, 
	multi_match: MultiMatchQuery, 
	nested: NestedQuery, 
	parent_id: ParentIdQuery, 
	percolate: PercolateQuery, 
	pinned: PinnedQuery, 
	prefix: NamedQuery[PrefixQuery | String], 
	query_string: QueryStringQuery, 
	range: NamedQuery[RangeQuery], 
	rank_feature: NamedQuery[RankFeatureQuery | String], 
	regexp: NamedQuery[RegexpQuery | String], 
	script: ScriptQuery, 
	script_score: ScriptScoreQuery, 
	shape: NamedQuery[ShapeQuery | String], 
	simple_query_string: SimpleQueryStringQuery, 
	span_containing: SpanContainingQuery, 
	field_masking_span: SpanFieldMaskingQuery, 
	span_first: SpanFirstQuery, 
	span_multi: SpanMultiTermQuery, 
	span_near: SpanNearQuery, 
	span_not: SpanNotQuery, 
	span_or: SpanOrQuery, 
	span_term: NamedQuery[SpanTermQuery | String], 
	span_within: SpanWithinQuery, 
	template: QueryTemplate, 
	term: NamedQuery[TermQuery | String | float | Boolean], 
	terms: NamedQuery[TermsQuery | Seq[String] | Seq[long]], 
	terms_set: NamedQuery[TermsSetQuery | String], 
	wildcard: NamedQuery[WildcardQuery | String], 
	`type`: TypeQuery
)

@JsonCodec case class QueryTemplate(
	source: String
)

@JsonCodec case class FieldLookup(
	id: Id, 
	index: IndexName, 
	path: Field, 
	routing: Routing
)

@JsonCodec case class FieldNameQuery(
	field: Field
)

@JsonCodec case class QueryBase(
	boost: float, 
	_name: String
)

@JsonCodec case class NamedQuery[TQuery](
	boost: float, 
	_name: String, 
	ignore_unmapped: Boolean
) extends AdditionalProperties[String, TQuery]

@JsonCodec case class CombinedFieldsQuery(
	query: String, 
	fields: Seq[Field], 
	operator: String
)
