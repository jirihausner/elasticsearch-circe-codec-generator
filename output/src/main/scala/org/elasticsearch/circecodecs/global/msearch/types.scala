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

package org.elasticsearch.circecodecs.global.msearch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.global.search.types.PointInTimeReference.{ PointInTimeReference }
import org.elasticsearch.circecodecs.global.search.types.suggester.{ SuggestContainer }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.aggregations.AggregationContainer.{ AggregationContainer }
import org.elasticsearch.circecodecs.types.common.{ ExpandWildcards, Indices, SearchType }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }
import org.elasticsearch.circecodecs.types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs.global.search.SearchResponse.{ Response as SearchResponse }

@JsonCodec case class Header(
	allow_no_indices: Boolean, 
	expand_wildcards: ExpandWildcards, 
	ignore_unavailable: Boolean, 
	index: Indices, 
	preference: String, 
	request_cache: Boolean, 
	routing: String, 
	search_type: SearchType
)

@JsonCodec case class Body(
	aggregations: Dictionary[String, AggregationContainer], 
	aggs: Dictionary[String, AggregationContainer], 
	query: QueryContainer, 
	from: integer, 
	size: integer, 
	pit: PointInTimeReference, 
	track_total_hits: Boolean | integer, 
	suggest: SuggestContainer | Dictionary[String, SuggestContainer]
)

@JsonCodec case class SearchResult[TDocument](
	status: integer
) extends SearchResponse[TDocument]
