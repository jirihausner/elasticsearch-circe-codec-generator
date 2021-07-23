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

package org.elasticsearch.circecodecs.global.reindex

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.Base.{ RequestBase }
import org.elasticsearch.circecodecs.types.common.{ Conflicts, WaitForActiveShards }
import org.elasticsearch.circecodecs.types.Numeric.{ long }
import org.elasticsearch.circecodecs.types.Scripting.{ Script }
import org.elasticsearch.circecodecs.types.Time.{ Time }
import org.elasticsearch.circecodecs.global.reindex.{ Destination, Source }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		refresh: Boolean, 
		requests_per_second: long, 
		scroll: Time, 
		slices: long, 
		timeout: Time, 
		wait_for_active_shards: WaitForActiveShards, 
		wait_for_completion: Boolean, 
		require_alias: Boolean
	)
	@JsonCodec case class Body(
		conflicts: Conflicts, 
		dest: Destination, 
		max_docs: long, 
		script: Script, 
		size: long, 
		source: Source
	)
}
