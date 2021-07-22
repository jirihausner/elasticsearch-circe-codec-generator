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

package org.elasticsearch.circecodecs.indices.add_block

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.Base.{ RequestBase }
import org.elasticsearch.circecodecs._types.common.{ ExpandWildcards, IndexName }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName, 
		block: IndicesBlockOptions
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		ignore_unavailable: Boolean, 
		master_timeout: Time, 
		timeout: Time
	)
	@JsonCodec case class Body(
	)
}


object IndicesBlockOptions extends Enumeration {
	type IndicesBlockOptions = Value

	val metadata = Value(0, "metadata")
	val read = Value(1, "read")
	val read_only = Value(2, "read_only")
	val write = Value(3, "write")
}

implicit val indicesBlockOptionsDecoder: Decoder[IndicesBlockOptions.Value] = Decoder.decodeEnumeration(IndicesBlockOptions)
implicit val indicesBlockOptionsEncoder: Encoder[IndicesBlockOptions.Value] = Decoder.encodeEnumeration(IndicesBlockOptions)
