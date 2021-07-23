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

package org.elasticsearch.circecodecs.ccr.put_auto_follow_pattern

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.Base.{ RequestBase }
import org.elasticsearch.circecodecs.types.common.{ ByteSize, IndexPattern, IndexPatterns, Name }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }
import org.elasticsearch.circecodecs.types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Name
	)
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
		remote_cluster: String, 
		follow_index_pattern: IndexPattern, 
		leader_index_patterns: IndexPatterns, 
		max_outstanding_read_requests: integer, 
		settings: Dictionary[String, UserDefinedValue], 
		max_outstanding_write_requests: integer, 
		read_poll_timeout: Time, 
		max_read_request_operation_count: integer, 
		max_read_request_size: ByteSize, 
		max_retry_delay: Time, 
		max_write_buffer_count: integer, 
		max_write_buffer_size: ByteSize, 
		max_write_request_operation_count: integer, 
		max_write_request_size: ByteSize
	)
}
