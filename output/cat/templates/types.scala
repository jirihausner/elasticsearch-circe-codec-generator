package com.converted.elasticsearch.cat.templates

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name, VersionString }

@JsonCodec case class TemplatesRecord(
	name: Name, 
	index_patterns: String, 
	order: String, 
	version: VersionString, 
	composed_of: String
)

