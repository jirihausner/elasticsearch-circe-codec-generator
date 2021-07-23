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

package org.elasticsearch.circecodecs.types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.mapping.{ PropertyBase }

@JsonCodec case class DynamicTemplate(
	mapping: PropertyBase, 
	`match`: String, 
	match_mapping_type: String, 
	match_pattern: MatchType, 
	path_match: String, 
	path_unmatch: String, 
	unmatch: String
)

object MatchType extends Enumeration {
	type MatchType = Value

	val simple = Value(0, "simple")
	val regex = Value(1, "regex")
}

implicit val matchTypeDecoder: Decoder[MatchType.Value] = Decoder.decodeEnumeration(MatchType)
implicit val matchTypeEncoder: Encoder[MatchType.Value] = Decoder.encodeEnumeration(MatchType)

object DynamicMapping extends Enumeration {
	type DynamicMapping = Value

	val strict = Value(0, "strict")
	val runtime = Value(1, "runtime")
	val true = Value(2, "true")
	val false = Value(3, "false")
}

implicit val dynamicMappingDecoder: Decoder[DynamicMapping.Value] = Decoder.decodeEnumeration(DynamicMapping)
implicit val dynamicMappingEncoder: Encoder[DynamicMapping.Value] = Decoder.encodeEnumeration(DynamicMapping)
