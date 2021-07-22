package com.converted.elasticsearch.async_search.submit

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.FieldCollapse.{ FieldCollapse }
import com.converted.elasticsearch._global.search._types.highlighting.{ Highlight }
import com.converted.elasticsearch._global.search._types.PointInTimeReference.{ PointInTimeReference }
import com.converted.elasticsearch._global.search._types.rescoring.{ Rescore }
import com.converted.elasticsearch._global.search._types.sort.{ Sort }
import com.converted.elasticsearch._global.search._types.SourceFilter.{ SourceFilter }
import com.converted.elasticsearch._global.search._types.suggester.{ SuggestContainer }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.aggregations.AggregationContainer.{ AggregationContainer }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ DefaultOperator, ExpandWildcards, Field, Fields, IndexName, Indices, Routing, SearchType, SuggestMode }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Scripting.{ ScriptField }
import com.converted.elasticsearch._types.Time.{ DateField, Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices
	)
	@JsonCodec case class QueryParameters(
		batched_reduce_size: Long, 
		wait_for_completion_timeout: Time, 
		keep_on_completion: Boolean, 
		typed_keys: Boolean
	)
	@JsonCodec case class Body(
		aggs: Dictionary(String, AggregationContainer), 
		allow_no_indices: Boolean, 
		allow_partial_search_results: Boolean, 
		analyzer: String, 
		analyze_wildcard: Boolean, 
		batched_reduce_size: Long, 
		collapse: FieldCollapse, 
		default_operator: DefaultOperator, 
		df: String, 
		docvalue_fields: Fields, 
		expand_wildcards: ExpandWildcards, 
		explain: Boolean, 
		from: integer, 
		highlight: Highlight, 
		ignore_throttled: Boolean, 
		ignore_unavailable: Boolean, 
		indices_boost: Array(Dictionary(IndexName, double)), 
		keep_alive: Time, 
		keep_on_completion: Boolean, 
		lenient: Boolean, 
		max_concurrent_shard_requests: Long, 
		min_score: double, 
		post_filter: QueryContainer, 
		preference: String, 
		profile: Boolean, 
		pit: PointInTimeReference, 
		query: QueryContainer, 
		query_on_query_string: String, 
		request_cache: Boolean, 
		rescore: Array(Rescore), 
		routing: Routing, 
		script_fields: Dictionary(String, ScriptField), 
		search_after: Array(UserDefinedValue), 
		search_type: SearchType, 
		sequence_number_primary_term: Boolean, 
		size: integer, 
		sort: Sort, 
		_source: Boolean | SourceFilter, 
		stats: Array(String), 
		stored_fields: Fields, 
		suggest: Dictionary(String, SuggestContainer), 
		suggest_field: Field, 
		suggest_mode: SuggestMode, 
		suggest_size: Long, 
		suggest_text: String, 
		terminate_after: Long, 
		timeout: String, 
		track_scores: Boolean, 
		track_total_hits: Boolean, 
		typed_keys: Boolean, 
		version: Boolean, 
		wait_for_completion_timeout: Time, 
		fields: Array(Field | DateField)
	)
}

