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

package org.elasticsearch.circecodecs._global.reindex_rethrottle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.BaseNode.{ BaseNode }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ HttpHeaders, Name, TaskId }
import org.elasticsearch.circecodecs._types.Numeric.{ float, long }
import org.elasticsearch.circecodecs._types.Retries.{ Retries }

@JsonCodec case class ReindexNode(
	tasks: Dictionary[TaskId, ReindexTask]
) extends BaseNode

@JsonCodec case class ReindexStatus(
	batches: long, 
	created: long, 
	deleted: long, 
	noops: long, 
	requests_per_second: float, 
	retries: Retries, 
	throttled_millis: long, 
	throttled_until_millis: long, 
	total: long, 
	updated: long, 
	version_conflicts: long
)

@JsonCodec case class ReindexTask(
	action: String, 
	cancellable: Boolean, 
	description: String, 
	id: long, 
	node: Name, 
	running_time_in_nanos: long, 
	start_time_in_millis: long, 
	status: ReindexStatus, 
	`type`: String, 
	headers: HttpHeaders
)
