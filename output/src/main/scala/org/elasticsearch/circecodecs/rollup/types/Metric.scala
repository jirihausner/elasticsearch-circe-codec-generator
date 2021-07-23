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

package org.elasticsearch.circecodecs.rollup.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.common.{ Field }

object Metric extends Enumeration {
	type Metric = Value

	val min = Value(0, "min")
	val max = Value(1, "max")
	val sum = Value(2, "sum")
	val avg = Value(3, "avg")
	val value_count = Value(4, "value_count")
}

implicit val metricDecoder: Decoder[Metric.Value] = Decoder.decodeEnumeration(Metric)
implicit val metricEncoder: Encoder[Metric.Value] = Decoder.encodeEnumeration(Metric)

@JsonCodec case class FieldMetric(
	field: Field, 
	metrics: Seq[Metric]
)
