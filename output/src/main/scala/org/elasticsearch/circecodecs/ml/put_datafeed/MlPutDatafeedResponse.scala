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
import org.elasticsearch.circecodecs._ml._types.Datafeed.{ ChunkingConfig, DatafeedIndicesOptions, DelayedDataCheckConfig }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.aggregations.AggregationContainer.{ AggregationContainer }
import org.elasticsearch.circecodecs._types.common.{ Id, Indices }
import org.elasticsearch.circecodecs._types.mapping.RuntimeFields.{ RuntimeFields }
import org.elasticsearch.circecodecs._types.Numeric.{ integer }
import org.elasticsearch.circecodecs._types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs._types.Scripting.{ ScriptField }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		aggregations: Dictionary[String, AggregationContainer], 
		chunking_config: ChunkingConfig, 
		delayed_data_check_config: DelayedDataCheckConfig, 
		datafeed_id: Id, 
		frequency: Time, 
		indices: Seq[String], 
		job_id: Id, 
		indices_options: DatafeedIndicesOptions, 
		max_empty_searches: integer, 
		query: QueryContainer, 
		query_delay: Time, 
		runtime_mappings: RuntimeFields, 
		script_fields: Dictionary[String, ScriptField], 
		scroll_size: integer
	)
}

