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

package org.elasticsearch.circecodecs.cat.data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.common.{ Id, IndexName, Name, Type, VersionString }

@JsonCodec case class DataFrameAnalyticsRecord(
	id: Id, 
	`type`: Type, 
	create_time: String, 
	version: VersionString, 
	source_index: IndexName, 
	dest_index: IndexName, 
	description: String, 
	model_memory_limit: String, 
	state: String, 
	failure_reason: String, 
	progress: String, 
	assignment_explanation: String, 
	`node.id`: Id, 
	`node.name`: Name, 
	`node.ephemeral_id`: Id, 
	`node.address`: String
)
