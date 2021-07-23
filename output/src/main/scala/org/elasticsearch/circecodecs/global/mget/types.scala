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

package org.elasticsearch.circecodecs.global.mget

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.global.search.types.SourceFilter.{ SourceFilter }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ Fields, Id, IndexName, Routing, SequenceNumber, Type, VersionNumber, VersionType }
import org.elasticsearch.circecodecs.types.Errors.{ MainError }
import org.elasticsearch.circecodecs.types.Numeric.{ integer, long }

@JsonCodec case class Operation(
	_id: MultiGetId, 
	_index: IndexName, 
	routing: Routing, 
	_source: Boolean | Fields | SourceFilter, 
	stored_fields: Fields, 
	_type: Type, 
	version: VersionNumber, 
	version_type: VersionType
)
type MultiGetId = String | integer

@JsonCodec case class Hit[TDocument](
	error: MainError, 
	fields: Dictionary[String, UserDefinedValue], 
	found: Boolean, 
	_id: Id, 
	_index: IndexName, 
	_primary_term: long, 
	_routing: Routing, 
	_seq_no: SequenceNumber, 
	_source: TDocument, 
	_type: Type, 
	_version: VersionNumber
)
