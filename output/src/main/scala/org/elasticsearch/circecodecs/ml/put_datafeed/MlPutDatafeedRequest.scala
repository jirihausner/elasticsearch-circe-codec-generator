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

package org.elasticsearch.circecodecs.ml.put_datafeed

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.ml.types.Datafeed.{ ChunkingConfig, DatafeedIndicesOptions, DelayedDataCheckConfig }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.aggregations.AggregationContainer.{ AggregationContainer }
import org.elasticsearch.circecodecs.types.Base.{ RequestBase }
import org.elasticsearch.circecodecs.types.common.{ ExpandWildcards, Id, Indices }
import org.elasticsearch.circecodecs.types.mapping.RuntimeFields.{ RuntimeFields }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }
import org.elasticsearch.circecodecs.types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs.types.Scripting.{ ScriptField }
import org.elasticsearch.circecodecs.types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		datafeed_id: Id
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		ignore_throttled: Boolean, 
		ignore_unavailable: Boolean
	)
	@JsonCodec case class Body(
		aggregations: Dictionary[String, AggregationContainer], 
		chunking_config: ChunkingConfig, 
		delayed_data_check_config: DelayedDataCheckConfig, 
		frequency: Time, 
		indices: Seq[String], 
		indexes: Seq[String], 
		indices_options: DatafeedIndicesOptions, 
		job_id: Id, 
		max_empty_searches: integer, 
		query: QueryContainer, 
		query_delay: Time, 
		runtime_mappings: RuntimeFields, 
		script_fields: Dictionary[String, ScriptField], 
		scroll_size: integer
	)
}
