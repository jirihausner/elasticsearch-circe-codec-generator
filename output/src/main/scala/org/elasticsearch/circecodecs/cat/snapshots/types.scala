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

package org.elasticsearch.circecodecs.cat.snapshots

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.Time.{ DateString, EpochMillis, Time }

@JsonCodec case class SnapshotsRecord(
	id: String, 
	repository: String, 
	status: String, 
	start_epoch: EpochMillis, 
	start_time: DateString, 
	end_epoch: EpochMillis, 
	end_time: DateString, 
	duration: Time, 
	indices: String, 
	successful_shards: String, 
	failed_shards: String, 
	total_shards: String, 
	reason: String
)
