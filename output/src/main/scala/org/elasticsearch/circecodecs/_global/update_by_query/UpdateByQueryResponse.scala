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

package org.elasticsearch.circecodecs._global.update_by_query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.common.{ TaskId }
import org.elasticsearch.circecodecs._types.Errors.{ BulkIndexByScrollFailure }
import org.elasticsearch.circecodecs._types.Numeric.{ float, long, ulong }
import org.elasticsearch.circecodecs._types.Retries.{ Retries }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		batches: long, 
		failures: Seq[BulkIndexByScrollFailure], 
		noops: long, 
		deleted: long, 
		requests_per_second: float, 
		retries: Retries, 
		task: TaskId, 
		timed_out: Boolean, 
		took: long, 
		total: long, 
		updated: long, 
		version_conflicts: long, 
		throttled_millis: ulong, 
		throttled_until_millis: ulong
	)
}

