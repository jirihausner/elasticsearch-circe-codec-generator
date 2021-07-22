package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ IndexName, Name, VersionNumber }
import com.converted.elasticsearch._types.mapping.TypeMapping.{ TypeMapping }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch.indices._types.{ Alias }

@JsonCodec case class TemplateMapping(
	aliases: Dictionary[IndexName, Alias], 
	index_patterns: Array[Name], 
	mappings: TypeMapping, 
	order: integer, 
	settings: Dictionary[String, UserDefinedValue], 
	version: VersionNumber
)
