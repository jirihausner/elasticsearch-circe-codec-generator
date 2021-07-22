package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.behaviors.{ AdditionalProperties }
import com.converted.elasticsearch._spec_utils.Dictionary.{ SingleKeyDictionary }
import com.converted.elasticsearch._types.common.{ Field, Id, IndexName, Routing }
import com.converted.elasticsearch._types.Numeric.{ float, long }
import com.converted.elasticsearch._types.query_dsl.{ BoolQuery, BoostingQuery, ConstantScoreQuery, DisMaxQuery, FunctionScoreQuery }
import com.converted.elasticsearch._types.query_dsl.{ CommonTermsQuery, IntervalsQuery, MatchBoolPrefixQuery, MatchPhrasePrefixQuery, MatchPhraseQuery, MatchQuery, MultiMatchQuery, QueryStringQuery, SimpleQueryStringQuery }
import com.converted.elasticsearch._types.query_dsl.{ GeoBoundingBoxQuery, GeoDistanceQuery, GeoPolygonQuery, GeoShapeQuery }
import com.converted.elasticsearch._types.query_dsl.{ HasChildQuery, HasParentQuery, NestedQuery, ParentIdQuery }
import com.converted.elasticsearch._types.query_dsl.{ MatchAllQuery }
import com.converted.elasticsearch._types.query_dsl.{ MatchNoneQuery }
import com.converted.elasticsearch._types.query_dsl.{ SpanContainingQuery, SpanFieldMaskingQuery, SpanFirstQuery, SpanMultiTermQuery, SpanNearQuery, SpanNotQuery, SpanOrQuery, SpanTermQuery, SpanWithinQuery }
import com.converted.elasticsearch._types.query_dsl.{ DistanceFeatureQuery, MoreLikeThisQuery, PercolateQuery, PinnedQuery, RankFeatureQuery, ScriptQuery, ScriptScoreQuery, ShapeQuery }
import com.converted.elasticsearch._types.query_dsl.{ ExistsQuery, FuzzyQuery, IdsQuery, PrefixQuery, RangeQuery, RegexpQuery, TermQuery, TermsQuery, TermsSetQuery, TypeQuery, WildcardQuery }

@JsonCodec case class QueryContainer(
	bool: BoolQuery, 
	boosting: BoostingQuery, 
	common: SingleKeyDictionary(Field, CommonTermsQuery | String), 
	combined_fields: CombinedFieldsQuery, 
	constant_score: ConstantScoreQuery, 
	dis_max: DisMaxQuery, 
	distance_feature: SingleKeyDictionary(Field, DistanceFeatureQuery | String) | DistanceFeatureQuery, 
	exists: ExistsQuery, 
	function_score: FunctionScoreQuery, 
	fuzzy: SingleKeyDictionary(Field, FuzzyQuery | String), 
	geo_bounding_box: NamedQuery(GeoBoundingBoxQuery | String), 
	geo_distance: GeoDistanceQuery, 
	geo_polygon: NamedQuery(GeoPolygonQuery | String), 
	geo_shape: NamedQuery(GeoShapeQuery | String), 
	has_child: HasChildQuery, 
	has_parent: HasParentQuery, 
	ids: IdsQuery, 
	intervals: NamedQuery(IntervalsQuery | String), 
	`match`: NamedQuery(MatchQuery | String | float | Boolean), 
	match_all: MatchAllQuery, 
	match_bool_prefix: NamedQuery(MatchBoolPrefixQuery | String), 
	match_none: MatchNoneQuery, 
	match_phrase: NamedQuery(MatchPhraseQuery | String), 
	match_phrase_prefix: NamedQuery(MatchPhrasePrefixQuery | String), 
	more_like_this: MoreLikeThisQuery, 
	multi_match: MultiMatchQuery, 
	nested: NestedQuery, 
	parent_id: ParentIdQuery, 
	percolate: PercolateQuery, 
	pinned: PinnedQuery, 
	prefix: NamedQuery(PrefixQuery | String), 
	query_string: QueryStringQuery, 
	range: NamedQuery(RangeQuery), 
	rank_feature: NamedQuery(RankFeatureQuery | String), 
	regexp: NamedQuery(RegexpQuery | String), 
	script: ScriptQuery, 
	script_score: ScriptScoreQuery, 
	shape: NamedQuery(ShapeQuery | String), 
	simple_query_string: SimpleQueryStringQuery, 
	span_containing: SpanContainingQuery, 
	field_masking_span: SpanFieldMaskingQuery, 
	span_first: SpanFirstQuery, 
	span_multi: SpanMultiTermQuery, 
	span_near: SpanNearQuery, 
	span_not: SpanNotQuery, 
	span_or: SpanOrQuery, 
	span_term: NamedQuery(SpanTermQuery | String), 
	span_within: SpanWithinQuery, 
	template: QueryTemplate, 
	term: NamedQuery(TermQuery | String | float | Boolean), 
	terms: NamedQuery(TermsQuery | Array(String) | Array(long)), 
	terms_set: NamedQuery(TermsSetQuery | String), 
	wildcard: NamedQuery(WildcardQuery | String), 
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
) extends AdditionalProperties(String, TQuery)

@JsonCodec case class CombinedFieldsQuery(
	query: String, 
	fields: Array(Field), 
	operator: String
)
