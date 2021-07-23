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

/**
 * @doc_url https://www.elastic.co/guide/en/elasticsearch/reference/current/cluster-health.html#cluster-health-api-response-body
 */
package org.elasticsearch.circecodecs.indices.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

object DataStreamHealthStatus extends Enumeration {
	type DataStreamHealthStatus = Value

	val gREEN = Value(0, "GREEN")
	val green = Value(1, "green")
	val yELLOW = Value(2, "YELLOW")
	val yellow = Value(3, "yellow")
	val rED = Value(4, "RED")
	val red = Value(5, "red")
}

implicit val dataStreamHealthStatusDecoder: Decoder[DataStreamHealthStatus.Value] = Decoder.decodeEnumeration(DataStreamHealthStatus)
implicit val dataStreamHealthStatusEncoder: Encoder[DataStreamHealthStatus.Value] = Decoder.encodeEnumeration(DataStreamHealthStatus)
