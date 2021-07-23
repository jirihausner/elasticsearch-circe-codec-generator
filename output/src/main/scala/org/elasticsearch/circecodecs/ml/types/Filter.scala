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

package org.elasticsearch.circecodecs.ml.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.common.{ Id }

@JsonCodec case class Filter(
	description: String, 
	filter_id: Id, 
	items: Seq[String]
)

@JsonCodec case class FilterRef(
	filter_id: Id, 
	filter_type: FilterType
)

object FilterType extends Enumeration {
	type FilterType = Value

	val include = Value(0, "include")
	val exclude = Value(1, "exclude")
}

implicit val filterTypeDecoder: Decoder[FilterType.Value] = Decoder.decodeEnumeration(FilterType)
implicit val filterTypeEncoder: Encoder[FilterType.Value] = Decoder.encodeEnumeration(FilterType)
