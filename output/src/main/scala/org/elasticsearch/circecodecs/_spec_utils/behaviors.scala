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
/*
 * This file hosts `behaviors`. We use this interfaces that are marked with a `@behavior` JS Doc annotation
 * to signal complicated mappings to the compiler -> canonical json -> client generators.
 *
 * These are problem sets that need a custom client solution.
 */

package org.elasticsearch.circecodecs._spec_utils

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.common.{ Names }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec sealed trait AdditionalProperties[TKey, TValue]

@JsonCodec case class CommonQueryParameters(
	error_trace: Boolean, 
	filter_path: String | Seq[String], 
	human: Boolean, 
	pretty: Boolean, 
	source_query_string: String
)

@JsonCodec case class CommonCatQueryParameters(
	format: String, 
	h: Names, 
	help: Boolean, 
	local: Boolean, 
	master_timeout: Time, 
	s: Seq[String], 
	v: Boolean
)
