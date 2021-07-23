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

package org.elasticsearch.circecodecs.cluster.health

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.common.{ Health, IndexName }
import org.elasticsearch.circecodecs.types.Numeric.{ integer, Percentage }
import org.elasticsearch.circecodecs.types.Time.{ EpochMillis }
import org.elasticsearch.circecodecs.cluster.health.{ IndexHealthStats }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		active_primary_shards: integer, 
		active_shards: integer, 
		active_shards_percent_as_number: Percentage, 
		cluster_name: String, 
		delayed_unassigned_shards: integer, 
		indices: Dictionary[IndexName, IndexHealthStats], 
		initializing_shards: integer, 
		number_of_data_nodes: integer, 
		number_of_in_flight_fetch: integer, 
		number_of_nodes: integer, 
		number_of_pending_tasks: integer, 
		relocating_shards: integer, 
		status: Health, 
		task_max_waiting_in_queue_millis: EpochMillis, 
		timed_out: Boolean, 
		unassigned_shards: integer
	)
}
