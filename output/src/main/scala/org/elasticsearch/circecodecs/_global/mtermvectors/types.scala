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

package org.elasticsearch.circecodecs._global.mtermvectors

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._global.termvectors.types.{ Filter, TermVector }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ Field, Fields, Id, IndexName, Routing, VersionNumber, VersionType }
import org.elasticsearch.circecodecs._types.Numeric.{ long }

@JsonCodec case class Operation(
	doc: Any, 
	fields: Fields, 
	field_statistics: Boolean, 
	filter: Filter, 
	_id: Id, 
	_index: IndexName, 
	offsets: Boolean, 
	payloads: Boolean, 
	positions: Boolean, 
	routing: Routing, 
	term_statistics: Boolean, 
	version: VersionNumber, 
	version_type: VersionType
)

@JsonCodec case class TermVectorsResult(
	found: Boolean, 
	id: Id, 
	index: IndexName, 
	term_vectors: Dictionary[Field, TermVector], 
	took: long, 
	version: VersionNumber
)
