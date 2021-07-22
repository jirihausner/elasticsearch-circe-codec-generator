package com.converted.elasticsearch._global.get_script_languages

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.get_script_languages.{ LanguageContext }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		language_contexts: Seq[LanguageContext], 
		types_allowed: Seq[String]
	)
}

