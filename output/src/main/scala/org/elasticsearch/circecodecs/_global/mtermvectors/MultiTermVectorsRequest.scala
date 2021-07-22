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
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ Fields, Id, IndexName, Routing, Type, VersionNumber, VersionType }
import org.elasticsearch.circecodecs._global.mtermvectors.{ Operation }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		fields: Fields, 
		field_statistics: Boolean, 
		offsets: Boolean, 
		payloads: Boolean, 
		positions: Boolean, 
		preference: String, 
		realtime: Boolean, 
		routing: Routing, 
		term_statistics: Boolean, 
		version: VersionNumber, 
		version_type: VersionType
	)
	@JsonCodec case class Body(
		docs: Seq[Operation], 
		ids: Seq[Id]
	)
}

