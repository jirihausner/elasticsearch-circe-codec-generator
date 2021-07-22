package com.converted.elasticsearch._global.search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field, Fields }

@JsonCodec case class SourceFilter(
	excludes: Fields, 
	includes: Fields, 
	exclude: Fields, 
	include: Fields
)


@JsonCodec case class DocValueField(
	field: Field, 
	format: String
)

