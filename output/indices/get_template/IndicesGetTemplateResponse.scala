package com.converted.elasticsearch.indices.get_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.TemplateMapping.{ TemplateMapping }
import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }

@JsonCodec case class Response extends DictionaryResponseBase(String, TemplateMapping)
