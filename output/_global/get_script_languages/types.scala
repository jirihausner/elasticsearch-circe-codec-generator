package com.converted.elasticsearch._global.get_script_languages

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Scripting.{ ScriptLanguage }

@JsonCodec case class LanguageContext(
	contexts: Seq[String], 
	language: ScriptLanguage
)
