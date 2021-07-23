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

package org.elasticsearch.circecodecs.cat.recovery

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.common.{ IndexName, Type }
import org.elasticsearch.circecodecs.types.Numeric.{ Percentage }

@JsonCodec case class RecoveryRecord(
	index: IndexName, 
	shard: String, 
	start_time: String, 
	start_time_millis: String, 
	stop_time: String, 
	stop_time_millis: String, 
	time: String, 
	`type`: Type, 
	stage: String, 
	source_host: String, 
	source_node: String, 
	target_host: String, 
	target_node: String, 
	repository: String, 
	snapshot: String, 
	files: String, 
	files_recovered: String, 
	files_percent: Percentage, 
	files_total: String, 
	bytes: String, 
	bytes_recovered: String, 
	bytes_percent: Percentage, 
	bytes_total: String, 
	translog_ops: String, 
	translog_ops_recovered: String, 
	translog_ops_percent: Percentage
)
