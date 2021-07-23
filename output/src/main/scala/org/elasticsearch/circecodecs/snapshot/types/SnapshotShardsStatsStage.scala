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
 * @doc_url https://www.elastic.co/guide/en/elasticsearch/reference/current/get-snapshot-status-api.html
 */
package org.elasticsearch.circecodecs.snapshot.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

object ShardsStatsStage extends Enumeration {
	type ShardsStatsStage = Value

	val dONE = Value(0, "DONE")
	val fAILURE = Value(1, "FAILURE")
	val fINALIZE = Value(2, "FINALIZE")
	val iNIT = Value(3, "INIT")
	val sTARTED = Value(4, "STARTED")
}

implicit val shardsStatsStageDecoder: Decoder[ShardsStatsStage.Value] = Decoder.decodeEnumeration(ShardsStatsStage)
implicit val shardsStatsStageEncoder: Encoder[ShardsStatsStage.Value] = Decoder.encodeEnumeration(ShardsStatsStage)
