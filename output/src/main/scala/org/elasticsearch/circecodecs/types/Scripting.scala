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

package org.elasticsearch.circecodecs.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.{ Id }

object ScriptLanguage extends Enumeration {
	type ScriptLanguage = Value

	val painless = Value(0, "painless")
	val expression = Value(1, "expression")
	val mustache = Value(2, "mustache")
	val java = Value(0, "java")
}

implicit val scriptLanguageDecoder: Decoder[ScriptLanguage.Value] = Decoder.decodeEnumeration(ScriptLanguage)
implicit val scriptLanguageEncoder: Encoder[ScriptLanguage.Value] = Decoder.encodeEnumeration(ScriptLanguage)

@JsonCodec case class StoredScript(
	lang: ScriptLanguage, 
	source: String
)

@JsonCodec case class ScriptBase(
	lang: ScriptLanguage, 
	params: Dictionary[String, UserDefinedValue]
)

@JsonCodec case class InlineScript(
	source: String
) extends ScriptBase

@JsonCodec case class IndexedScript(
	id: Id
) extends ScriptBase
type Script = InlineScript | IndexedScript | String

@JsonCodec case class ScriptField(
	script: Script
)
