package com.converted.elasticsearch._global.search

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.aggregations.AggregationContainer.{ AggregationContainer }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ DefaultOperator, ExpandWildcards, Field, Fields, IndexName, Indices, Routing, SearchType, SuggestMode, Types, VersionString }
import com.converted.elasticsearch._types.mapping.RuntimeFields.{ RuntimeFields }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Scripting.{ ScriptField }
import com.converted.elasticsearch._types.SlicedScroll.{ SlicedScroll }
import com.converted.elasticsearch._types.Time.{ DateField, Time }
import com.converted.elasticsearch._global.search.{ FieldCollapse }
import com.converted.elasticsearch._global.search.{ Highlight }
import com.converted.elasticsearch._global.search.{ PointInTimeReference }
import com.converted.elasticsearch._global.search.{ Rescore }
import com.converted.elasticsearch._global.search.{ Sort }
import com.converted.elasticsearch._global.search.{ DocValueField, SourceFilter }
import com.converted.elasticsearch._global.search.{ SuggestContainer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		`type`: Types
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		allow_partial_search_results: Boolean, 
		analyzer: String, 
		analyze_wildcard: Boolean, 
		batched_reduce_size: long, 
		ccs_minimize_roundtrips: Boolean, 
		default_operator: DefaultOperator, 
		df: String, 
		docvalue_fields: Fields, 
		expand_wildcards: ExpandWildcards, 
		explain: Boolean, 
		ignore_throttled: Boolean, 
		ignore_unavailable: Boolean, 
		lenient: Boolean, 
		max_concurrent_shard_requests: long, 
		min_compatible_shard_node: VersionString, 
		preference: String, 
		pre_filter_shard_size: long, 
		request_cache: Boolean, 
		routing: Routing, 
		scroll: Time, 
		search_type: SearchType, 
		stats: Array[String], 
		stored_fields: Fields, 
		suggest_field: Field, 
		suggest_mode: SuggestMode, 
		suggest_size: long, 
		suggest_text: String, 
		terminate_after: long, 
		timeout: Time, 
		track_total_hits: Boolean | integer, 
		track_scores: Boolean, 
		typed_keys: Boolean, 
		rest_total_hits_as_int: Boolean, 
		version: Boolean, 
		_source: Boolean | Fields, 
		_source_excludes: Fields, 
		_source_includes: Fields, 
		seq_no_primary_term: Boolean, 
		q: String, 
		size: integer, 
		from: integer, 
		sort: String | Array[String]
	)
	@JsonCodec case class Body(
		aggs: Dictionary[String, AggregationContainer], 
		aggregations: Dictionary[String, AggregationContainer], 
		collapse: FieldCollapse, 
		explain: Boolean, 
		from: integer, 
		highlight: Highlight, 
		track_total_hits: Boolean | integer, 
		indices_boost: Array[Dictionary[IndexName, double]], 
		docvalue_fields: DocValueField | Array[Field | DocValueField], 
		min_score: double, 
		post_filter: QueryContainer, 
		profile: Boolean, 
		query: QueryContainer, 
		rescore: Rescore | Array[Rescore], 
		script_fields: Dictionary[String, ScriptField], 
		search_after: Array[integer | String], 
		size: integer, 
		slice: SlicedScroll, 
		sort: Sort, 
		_source: Boolean | Fields | SourceFilter, 
		fields: Array[Field | DateField], 
		suggest: SuggestContainer | Dictionary[String, SuggestContainer], 
		terminate_after: long, 
		timeout: String, 
		track_scores: Boolean, 
		version: Boolean, 
		seq_no_primary_term: Boolean, 
		stored_fields: Fields, 
		pit: PointInTimeReference, 
		runtime_mappings: RuntimeFields, 
		stats: Array[String]
	)
}

