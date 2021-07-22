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

package org.elasticsearch.circecodecs._global.search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.Numeric.{ double, integer }
import org.elasticsearch.circecodecs._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class Rescore(
	query: RescoreQuery, 
	window_size: integer
)

@JsonCodec case class RescoreQuery(
	rescore_query: QueryContainer, 
	query_weight: double, 
	rescore_query_weight: double, 
	score_mode: ScoreMode
)

object ScoreMode extends Enumeration {
	type ScoreMode = Value

	val avg = Value(0, "avg")
	val max = Value(1, "max")
	val min = Value(2, "min")
	val multiply = Value(3, "multiply")
	val total = Value(4, "total")
}

implicit val scoreModeDecoder: Decoder[ScoreMode.Value] = Decoder.decodeEnumeration(ScoreMode)
implicit val scoreModeEncoder: Encoder[ScoreMode.Value] = Decoder.encodeEnumeration(ScoreMode)
