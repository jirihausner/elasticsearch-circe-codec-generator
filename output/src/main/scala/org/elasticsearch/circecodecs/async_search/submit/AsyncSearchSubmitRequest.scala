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

package org.elasticsearch.circecodecs.async_search.submit

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._global.search._types.FieldCollapse.{ FieldCollapse }
import org.elasticsearch.circecodecs._global.search._types.highlighting.{ Highlight }
import org.elasticsearch.circecodecs._global.search._types.PointInTimeReference.{ PointInTimeReference }
import org.elasticsearch.circecodecs._global.search._types.rescoring.{ Rescore }
import org.elasticsearch.circecodecs._global.search._types.sort.{ Sort }
import org.elasticsearch.circecodecs._global.search._types.SourceFilter.{ SourceFilter }
import org.elasticsearch.circecodecs._global.search._types.suggester.{ SuggestContainer }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.aggregations.AggregationContainer.{ AggregationContainer }
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ DefaultOperator, ExpandWildcards, Field, Fields, IndexName, Indices, Routing, SearchType, SuggestMode }
import org.elasticsearch.circecodecs._types.Numeric.{ double, integer, long }
import org.elasticsearch.circecodecs._types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs._types.Scripting.{ ScriptField }
import org.elasticsearch.circecodecs._types.Time.{ DateField, Time }

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
		batched_reduce_size: long, 
		wait_for_completion_timeout: Time, 
		keep_on_completion: Boolean, 
		typed_keys: Boolean
	)
	@JsonCodec case class Body(
		aggs: Dictionary[String, AggregationContainer], 
		allow_no_indices: Boolean, 
		allow_partial_search_results: Boolean, 
		analyzer: String, 
		analyze_wildcard: Boolean, 
		batched_reduce_size: long, 
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
		indices_boost: Seq[Dictionary[IndexName, double]], 
		keep_alive: Time, 
		keep_on_completion: Boolean, 
		lenient: Boolean, 
		max_concurrent_shard_requests: long, 
		min_score: double, 
		post_filter: QueryContainer, 
		preference: String, 
		profile: Boolean, 
		pit: PointInTimeReference, 
		query: QueryContainer, 
		query_on_query_string: String, 
		request_cache: Boolean, 
		rescore: Seq[Rescore], 
		routing: Routing, 
		script_fields: Dictionary[String, ScriptField], 
		search_after: Seq[UserDefinedValue], 
		search_type: SearchType, 
		sequence_number_primary_term: Boolean, 
		size: integer, 
		sort: Sort, 
		_source: Boolean | SourceFilter, 
		stats: Seq[String], 
		stored_fields: Fields, 
		suggest: Dictionary[String, SuggestContainer], 
		suggest_field: Field, 
		suggest_mode: SuggestMode, 
		suggest_size: long, 
		suggest_text: String, 
		terminate_after: long, 
		timeout: String, 
		track_scores: Boolean, 
		track_total_hits: Boolean, 
		typed_keys: Boolean, 
		version: Boolean, 
		wait_for_completion_timeout: Time, 
		fields: Seq[Field | DateField]
	)
}

