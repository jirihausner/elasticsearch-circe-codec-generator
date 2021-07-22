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
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ Field }
import org.elasticsearch.circecodecs._types.Scripting.{ Script }
type RuntimeFields = Dictionary[Field, RuntimeField]

@JsonCodec case class RuntimeField(
	format: String, 
	script: Script, 
	`type`: RuntimeFieldType
)

object RuntimeFieldType extends Enumeration {
	type RuntimeFieldType = Value

	val boolean = Value(0, "boolean")
	val date = Value(1, "date")
	val double = Value(2, "double")
	val geo_point = Value(3, "geo_point")
	val ip = Value(4, "ip")
	val keyword = Value(5, "keyword")
	val long = Value(6, "long")
}

implicit val runtimeFieldTypeDecoder: Decoder[RuntimeFieldType.Value] = Decoder.decodeEnumeration(RuntimeFieldType)
implicit val runtimeFieldTypeEncoder: Encoder[RuntimeFieldType.Value] = Decoder.encodeEnumeration(RuntimeFieldType)
