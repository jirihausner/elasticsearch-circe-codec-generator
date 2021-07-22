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

package org.elasticsearch.circecodecs._types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ Fields, Field }
import org.elasticsearch.circecodecs._types.Numeric.{ double }
import org.elasticsearch.circecodecs._types.aggregations.{ Aggregation }

@JsonCodec case class MatrixAggregation(
	fields: Fields, 
	missing: Dictionary[Field, double]
) extends Aggregation

@JsonCodec case class MatrixStatsAggregation(
	mode: MatrixStatsMode
) extends MatrixAggregation

object MatrixStatsMode extends Enumeration {
	type MatrixStatsMode = Value

	val avg = Value(0, "avg")
	val min = Value(1, "min")
	val max = Value(2, "max")
	val sum = Value(3, "sum")
	val median = Value(4, "median")
}

implicit val matrixStatsModeDecoder: Decoder[MatrixStatsMode.Value] = Decoder.decodeEnumeration(MatrixStatsMode)
implicit val matrixStatsModeEncoder: Encoder[MatrixStatsMode.Value] = Decoder.encodeEnumeration(MatrixStatsMode)
