package com.converted.elasticsearch.cat.templates

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.templates.{ TemplatesRecord }

@JsonCodec case class Response(
	body: Array(TemplatesRecord)
)
