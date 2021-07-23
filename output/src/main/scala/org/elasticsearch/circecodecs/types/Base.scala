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

package org.elasticsearch.circecodecs.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.behaviors.{ CommonQueryParameters }
import org.elasticsearch.circecodecs.types.{ Id, IndexName, SequenceNumber, Type, VersionNumber, VersionString }
import org.elasticsearch.circecodecs.types.{ ErrorCause, MainError }
import org.elasticsearch.circecodecs.types.{ integer, long }
import org.elasticsearch.circecodecs.types.{ Result }
import org.elasticsearch.circecodecs.types.{ ShardStatistics }
import org.elasticsearch.circecodecs.types.{ DateString }

@JsonCodec case class RequestBase extends CommonQueryParameters

@JsonCodec case class WriteResponseBase(
	_id: Id, 
	_index: IndexName, 
	_primary_term: long, 
	result: Result, 
	_seq_no: SequenceNumber, 
	_shards: ShardStatistics, 
	_type: Type, 
	_version: VersionNumber, 
	forced_refresh: Boolean
)

@JsonCodec case class AcknowledgedResponseBase(
	acknowledged: Boolean
)

@JsonCodec sealed trait DictionaryResponseBase[TKey, TValue]

@JsonCodec sealed trait DynamicResponseBase

@JsonCodec case class ElasticsearchVersionInfo(
	build_date: DateString, 
	build_flavor: String, 
	build_hash: String, 
	build_snapshot: Boolean, 
	build_type: String, 
	lucene_version: VersionString, 
	minimum_index_compatibility_version: VersionString, 
	minimum_wire_compatibility_version: VersionString, 
	number: String
)

@JsonCodec case class ErrorResponseBase(
	error: MainError | String, 
	status: integer
)

@JsonCodec case class IndicesResponseBase(
	_shards: ShardStatistics
) extends AcknowledgedResponseBase

@JsonCodec case class ShardsOperationResponseBase(
	_shards: ShardStatistics
)

@JsonCodec sealed trait CustomResponseBuilderBase
