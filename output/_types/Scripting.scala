package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.{ Id }

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
