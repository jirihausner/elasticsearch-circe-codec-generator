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

package org.elasticsearch.circecodecs._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

object TermVectorOption extends Enumeration {
	type TermVectorOption = Value

	val no = Value(0, "no")
	val yes = Value(1, "yes")
	val with_offsets = Value(2, "with_offsets")
	val with_positions = Value(3, "with_positions")
	val with_positions_offsets = Value(4, "with_positions_offsets")
	val with_positions_offsets_payloads = Value(5, "with_positions_offsets_payloads")
}

implicit val termVectorOptionDecoder: Decoder[TermVectorOption.Value] = Decoder.decodeEnumeration(TermVectorOption)
implicit val termVectorOptionEncoder: Encoder[TermVectorOption.Value] = Decoder.encodeEnumeration(TermVectorOption)
