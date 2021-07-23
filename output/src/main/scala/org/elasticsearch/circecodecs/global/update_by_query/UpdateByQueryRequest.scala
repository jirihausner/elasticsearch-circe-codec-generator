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

package org.elasticsearch.circecodecs.global.update_by_query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.Base.{ RequestBase }
import org.elasticsearch.circecodecs.types.common.{ Conflicts, DefaultOperator, ExpandWildcards, Fields, Indices, Routing, SearchType, Types, WaitForActiveShards }
import org.elasticsearch.circecodecs.types.Numeric.{ long }
import org.elasticsearch.circecodecs.types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs.types.Scripting.{ Script }
import org.elasticsearch.circecodecs.types.SlicedScroll.{ SlicedScroll }
import org.elasticsearch.circecodecs.types.Time.{ Time }

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
		analyzer: String, 
		analyze_wildcard: Boolean, 
		conflicts: Conflicts, 
		default_operator: DefaultOperator, 
		df: String, 
		expand_wildcards: ExpandWildcards, 
		from: long, 
		ignore_unavailable: Boolean, 
		lenient: Boolean, 
		pipeline: String, 
		preference: String, 
		query_on_query_string: String, 
		refresh: Boolean, 
		request_cache: Boolean, 
		requests_per_second: long, 
		routing: Routing, 
		scroll: Time, 
		scroll_size: long, 
		search_timeout: Time, 
		search_type: SearchType, 
		size: long, 
		slices: long, 
		sort: Seq[String], 
		source_enabled: Boolean, 
		source_excludes: Fields, 
		source_includes: Fields, 
		stats: Seq[String], 
		terminate_after: long, 
		timeout: Time, 
		version: Boolean, 
		version_type: Boolean, 
		wait_for_active_shards: WaitForActiveShards, 
		wait_for_completion: Boolean
	)
	@JsonCodec case class Body(
		max_docs: long, 
		query: QueryContainer, 
		script: Script, 
		slice: SlicedScroll, 
		conflicts: Conflicts
	)
}
