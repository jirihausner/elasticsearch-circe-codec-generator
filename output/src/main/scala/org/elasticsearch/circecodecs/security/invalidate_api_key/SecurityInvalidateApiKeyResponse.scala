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

package org.elasticsearch.circecodecs.security.invalidate_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.Errors.{ ErrorCause }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		error_count: integer, 
		error_details: Seq[ErrorCause], 
		invalidated_api_keys: Seq[String], 
		previously_invalidated_api_keys: Seq[String]
	)
}
