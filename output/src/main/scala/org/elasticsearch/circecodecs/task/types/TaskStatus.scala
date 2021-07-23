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

package org.elasticsearch.circecodecs.task.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.Numeric.{ float, long }
import org.elasticsearch.circecodecs.types.Retries.{ Retries }
import org.elasticsearch.circecodecs.types.Time.{ Time }

@JsonCodec case class Status(
	batches: long, 
	canceled: String, 
	created: long, 
	deleted: long, 
	noops: long, 
	failures: Seq[String], 
	requests_per_second: float, 
	retries: Retries, 
	throttled: Time, 
	throttled_millis: long, 
	throttled_until: Time, 
	throttled_until_millis: long, 
	timed_out: Boolean, 
	took: long, 
	total: long, 
	updated: long, 
	version_conflicts: long
)
