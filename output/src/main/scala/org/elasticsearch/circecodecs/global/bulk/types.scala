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
// TODO remap this as a good bulk response item and an error response item
package org.elasticsearch.circecodecs.global.bulk

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.common.{ InlineGet }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ Id, IndexName, Routing, SequenceNumber, VersionNumber, VersionType }
import org.elasticsearch.circecodecs.types.Errors.{ ErrorCause }
import org.elasticsearch.circecodecs.types.Numeric.{ integer, long }
import org.elasticsearch.circecodecs.types.Stats.{ ShardStatistics }

@JsonCodec case class ResponseItemBase(
	_id: String | null, 
	_index: String, 
	status: integer, 
	error: ErrorCause, 
	_primary_term: long, 
	result: String, 
	_seq_no: SequenceNumber, 
	_shards: ShardStatistics, 
	_type: String, 
	_version: VersionNumber, 
	forced_refresh: Boolean, 
	get: InlineGet[Dictionary[String, UserDefinedValue]]
)

@JsonCodec case class ResponseItemContainer(
	index: IndexResponseItem, 
	create: CreateResponseItem, 
	update: UpdateResponseItem, 
	delete: DeleteResponseItem
)

@JsonCodec case class IndexResponseItem extends ResponseItemBase

@JsonCodec case class CreateResponseItem extends ResponseItemBase

@JsonCodec case class UpdateResponseItem extends ResponseItemBase

@JsonCodec case class DeleteResponseItem extends ResponseItemBase

@JsonCodec case class Operation(
	_id: Id, 
	_index: IndexName, 
	retry_on_conflict: integer, 
	routing: Routing, 
	version: VersionNumber, 
	version_type: VersionType
)

@JsonCodec case class OperationContainer(
	index: IndexOperation, 
	create: CreateOperation, 
	update: UpdateOperation, 
	delete: DeleteOperation
)

@JsonCodec case class IndexOperation extends Operation

@JsonCodec case class CreateOperation extends Operation

@JsonCodec case class UpdateOperation extends Operation

@JsonCodec case class DeleteOperation extends Operation
