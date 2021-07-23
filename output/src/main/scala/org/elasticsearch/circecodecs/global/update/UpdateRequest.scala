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

package org.elasticsearch.circecodecs.global.update

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.global.search.types.SourceFilter.{ SourceFilter }
import org.elasticsearch.circecodecs.types.Base.{ RequestBase }
import org.elasticsearch.circecodecs.types.common.{ Fields, Id, IndexName, Refresh, Routing, SequenceNumber, Type, WaitForActiveShards }
import org.elasticsearch.circecodecs.types.Numeric.{ long }
import org.elasticsearch.circecodecs.types.Scripting.{ Script }
import org.elasticsearch.circecodecs.types.Time.{ Time }

@JsonCodec case class Request[TDocument, TPartialDocument](
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id, 
		index: IndexName, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		if_primary_term: long, 
		if_seq_no: SequenceNumber, 
		lang: String, 
		refresh: Refresh, 
		require_alias: Boolean, 
		retry_on_conflict: long, 
		routing: Routing, 
		source_enabled: Boolean, 
		timeout: Time, 
		wait_for_active_shards: WaitForActiveShards, 
		_source: Boolean | Fields, 
		_source_excludes: Fields, 
		_source_includes: Fields
	)
	@JsonCodec case class Body(
		detect_noop: Boolean, 
		doc: TPartialDocument, 
		doc_as_upsert: Boolean, 
		script: Script, 
		scripted_upsert: Boolean, 
		_source: Boolean | SourceFilter, 
		upsert: TDocument
	)
}
