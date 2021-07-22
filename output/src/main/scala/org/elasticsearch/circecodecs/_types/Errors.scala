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

package org.elasticsearch.circecodecs._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._global.scripts_painless_execute.types.{ PainlessExecutionPosition }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.{ HttpHeaders, Id, Ids, IndexName, Uuid }
import org.elasticsearch.circecodecs._types.{ integer, long }

@JsonCodec case class ErrorCause(
	`type`: String, 
	reason: String, 
	caused_by: ErrorCause, 
	shard: integer | String, 
	stack_trace: String, 
	root_cause: Seq[ErrorCause], 
	bytes_limit: long, 
	bytes_wanted: long, 
	column: integer, 
	col: integer, 
	failed_shards: Seq[ShardFailure], 
	grouped: Boolean, 
	index: IndexName, 
	index_uuid: Uuid, 
	language: String, 
	licensed_expired_feature: String, 
	line: integer, 
	max_buckets: integer, 
	phase: String, 
	property_name: String, 
	processor_type: String, 
	resource_id: Ids, 
	resource_type: String, 
	script: String, 
	script_stack: Seq[String], 
	header: HttpHeaders, 
	lang: String, 
	position: PainlessExecutionPosition
)

@JsonCodec case class MainError(
	headers: Dictionary[String, String], 
	root_cause: Seq[ErrorCause]
) extends ErrorCause

@JsonCodec case class ShardFailure(
	index: IndexName, 
	node: String, 
	reason: ErrorCause, 
	shard: integer, 
	status: String
)

@JsonCodec case class BulkIndexByScrollFailure(
	cause: MainError, 
	id: Id, 
	index: IndexName, 
	status: integer, 
	`type`: String
)
