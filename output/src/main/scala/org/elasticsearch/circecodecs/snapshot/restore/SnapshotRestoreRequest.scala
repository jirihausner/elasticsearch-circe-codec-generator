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

package org.elasticsearch.circecodecs.snapshot.restore

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._indices.put_settings.IndicesPutSettingsRequest.{ Request as IndicesPutSettingsRequest }
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ Indices, Name }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		repository: Name, 
		snapshot: Name
	)
	@JsonCodec case class QueryParameters(
		master_timeout: Time, 
		wait_for_completion: Boolean
	)
	@JsonCodec case class Body(
		ignore_index_settings: Seq[String], 
		ignore_unavailable: Boolean, 
		include_aliases: Boolean, 
		include_global_state: Boolean, 
		index_settings: IndicesPutSettingsRequest, 
		indices: Indices, 
		partial: Boolean, 
		rename_pattern: String, 
		rename_replacement: String
	)
}

