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

package org.elasticsearch.circecodecs._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

object VisitorScope extends Enumeration {
	type VisitorScope = Value

	val unknown = Value(0, "Unknown")
	val query = Value(1, "Query")
	val filter = Value(2, "Filter")
	val must = Value(3, "Must")
	val mustNot = Value(4, "MustNot")
	val should = Value(5, "Should")
	val positiveQuery = Value(6, "PositiveQuery")
	val negativeQuery = Value(7, "NegativeQuery")
	val span = Value(8, "Span")
}

implicit val visitorScopeDecoder: Decoder[VisitorScope.Value] = Decoder.decodeEnumeration(VisitorScope)
implicit val visitorScopeEncoder: Encoder[VisitorScope.Value] = Decoder.encodeEnumeration(VisitorScope)
