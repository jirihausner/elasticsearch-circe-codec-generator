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

package org.elasticsearch.circecodecs._global.reindex

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._global.search._types.sort.{ Sort }
import org.elasticsearch.circecodecs._types.common.{ Fields, IndexName, Indices, OpType, Password, Routing, Username, VersionType }
import org.elasticsearch.circecodecs._types.Networking.{ Host }
import org.elasticsearch.circecodecs._types.Numeric.{ integer }
import org.elasticsearch.circecodecs._types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs._types.SlicedScroll.{ SlicedScroll }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec case class Destination(
	index: IndexName, 
	op_type: OpType, 
	pipeline: String, 
	routing: Routing, 
	version_type: VersionType
)

@JsonCodec case class Source(
	index: Indices, 
	query: QueryContainer, 
	remote: RemoteSource, 
	size: integer, 
	slice: SlicedScroll, 
	sort: Sort, 
	_source: Fields
)

@JsonCodec case class RemoteSource(
	connect_timeout: Time, 
	host: Host, 
	username: Username, 
	password: Password, 
	socket_timeout: Time
)
