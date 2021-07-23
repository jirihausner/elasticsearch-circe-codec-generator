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

package org.elasticsearch.circecodecs.global.search

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.aggregations.AggregationContainer.{ AggregationContainer }
import org.elasticsearch.circecodecs.types.Base.{ RequestBase }
import org.elasticsearch.circecodecs.types.common.{ DefaultOperator, ExpandWildcards, Field, Fields, IndexName, Indices, Routing, SearchType, SuggestMode, Types, VersionString }
import org.elasticsearch.circecodecs.types.mapping.RuntimeFields.{ RuntimeFields }
import org.elasticsearch.circecodecs.types.Numeric.{ double, integer, long }
import org.elasticsearch.circecodecs.types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs.types.Scripting.{ ScriptField }
import org.elasticsearch.circecodecs.types.SlicedScroll.{ SlicedScroll }
import org.elasticsearch.circecodecs.types.Time.{ DateField, Time }
import org.elasticsearch.circecodecs.global.search.{ FieldCollapse }
import org.elasticsearch.circecodecs.global.search.{ Highlight }
import org.elasticsearch.circecodecs.global.search.{ PointInTimeReference }
import org.elasticsearch.circecodecs.global.search.{ Rescore }
import org.elasticsearch.circecodecs.global.search.{ Sort }
import org.elasticsearch.circecodecs.global.search.{ DocValueField, SourceFilter }
import org.elasticsearch.circecodecs.global.search.{ SuggestContainer }

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
		stats: Seq[String], 
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
		sort: String | Seq[String]
	)
	@JsonCodec case class Body(
		aggs: Dictionary[String, AggregationContainer], 
		aggregations: Dictionary[String, AggregationContainer], 
		collapse: FieldCollapse, 
		explain: Boolean, 
		from: integer, 
		highlight: Highlight, 
		track_total_hits: Boolean | integer, 
		indices_boost: Seq[Dictionary[IndexName, double]], 
		docvalue_fields: DocValueField | Seq[Field | DocValueField], 
		min_score: double, 
		post_filter: QueryContainer, 
		profile: Boolean, 
		query: QueryContainer, 
		rescore: Rescore | Seq[Rescore], 
		script_fields: Dictionary[String, ScriptField], 
		search_after: Seq[integer | String], 
		size: integer, 
		slice: SlicedScroll, 
		sort: Sort, 
		_source: Boolean | Fields | SourceFilter, 
		fields: Seq[Field | DateField], 
		suggest: SuggestContainer | Dictionary[String, SuggestContainer], 
		terminate_after: long, 
		timeout: String, 
		track_scores: Boolean, 
		version: Boolean, 
		seq_no_primary_term: Boolean, 
		stored_fields: Fields, 
		pit: PointInTimeReference, 
		runtime_mappings: RuntimeFields, 
		stats: Seq[String]
	)
}
