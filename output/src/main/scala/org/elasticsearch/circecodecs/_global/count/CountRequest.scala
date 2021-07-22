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

package org.elasticsearch.circecodecs._global.count

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ DefaultOperator, ExpandWildcards, Indices, Routing, Types }
import org.elasticsearch.circecodecs._types.Numeric.{ double, long }
import org.elasticsearch.circecodecs._types.query_dsl.abstractions.{ QueryContainer }

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
		default_operator: DefaultOperator, 
		df: String, 
		expand_wildcards: ExpandWildcards, 
		ignore_throttled: Boolean, 
		ignore_unavailable: Boolean, 
		lenient: Boolean, 
		min_score: double, 
		preference: String, 
		query_on_query_string: String, 
		routing: Routing, 
		terminate_after: long, 
		q: String
	)
	@JsonCodec case class Body(
		query: QueryContainer
	)
}

