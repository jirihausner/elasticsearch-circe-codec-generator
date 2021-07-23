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

package org.elasticsearch.circecodecs.eql.search

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.Base.{ RequestBase }
import org.elasticsearch.circecodecs.types.common.{ ExpandWildcards, Field, IndexName }
import org.elasticsearch.circecodecs.types.Numeric.{ float, uint }
import org.elasticsearch.circecodecs.types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs.types.Time.{ Time }
import org.elasticsearch.circecodecs.eql.search.{ ResultPosition, SearchFieldFormatted }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		ignore_unavailable: Boolean, 
		keep_alive: Time, 
		keep_on_completion: Boolean, 
		wait_for_completion_timeout: Time
	)
	@JsonCodec case class Body(
		query: String, 
		case_sensitive: Boolean, 
		event_category_field: Field, 
		tiebreaker_field: Field, 
		timestamp_field: Field, 
		fetch_size: uint, 
		filter: QueryContainer | Seq[QueryContainer], 
		keep_alive: Time, 
		keep_on_completion: Boolean, 
		wait_for_completion_timeout: Time, 
		size: uint | float, 
		fields: Seq[Field | SearchFieldFormatted], 
		result_position: ResultPosition
	)
}
