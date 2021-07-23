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

package org.elasticsearch.circecodecs.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

object Result extends Enumeration {
	type Result = Value

	val error = Value(0, "Error")
	val created = Value(1, "created")
	val updated = Value(2, "updated")
	val deleted = Value(3, "deleted")
	val not_found = Value(4, "not_found")
	val noop = Value(5, "noop")
}

implicit val resultDecoder: Decoder[Result.Value] = Decoder.decodeEnumeration(Result)
implicit val resultEncoder: Encoder[Result.Value] = Decoder.encodeEnumeration(Result)
