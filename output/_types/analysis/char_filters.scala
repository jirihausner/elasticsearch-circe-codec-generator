package com.converted.elasticsearch._types.analysis

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ VersionString }
import com.converted.elasticsearch._types.analysis.{ PatternReplaceTokenFilter }

@JsonCodec case class CharFilterBase(
	`type`: String, 
	version: VersionString
)

type CharFilter = HtmlStripCharFilter | MappingCharFilter | PatternReplaceTokenFilter

@JsonCodec case class HtmlStripCharFilter extends CharFilterBase


@JsonCodec case class MappingCharFilter(
	mappings: Array(String), 
	mappings_path: String
) extends CharFilterBase


@JsonCodec case class PatternReplaceCharFilter(
	flags: String, 
	pattern: String, 
	replacement: String
) extends CharFilterBase

