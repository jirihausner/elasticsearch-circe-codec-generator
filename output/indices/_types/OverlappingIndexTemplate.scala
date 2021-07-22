package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ IndexName, Name }

@JsonCodec case class OverlappingIndexTemplate(
	name: Name, 
	index_patterns: Seq[IndexName]
)
