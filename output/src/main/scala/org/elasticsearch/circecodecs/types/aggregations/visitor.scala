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

package org.elasticsearch.circecodecs.types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

object AggregationVisitorScope extends Enumeration {
	type AggregationVisitorScope = Value

	val unknown = Value(0, "Unknown")
	val aggregation = Value(1, "Aggregation")
	val bucket = Value(2, "Bucket")
}

implicit val aggregationVisitorScopeDecoder: Decoder[AggregationVisitorScope.Value] = Decoder.decodeEnumeration(AggregationVisitorScope)
implicit val aggregationVisitorScopeEncoder: Encoder[AggregationVisitorScope.Value] = Decoder.encodeEnumeration(AggregationVisitorScope)
