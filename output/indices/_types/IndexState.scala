package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.mapping.TypeMapping.{ TypeMapping }
import com.converted.elasticsearch.indices._types.{ Alias }
import com.converted.elasticsearch.indices._types.{ IndexSettings }

@JsonCodec case class IndexState(
	aliases: Dictionary(IndexName, Alias), 
	mappings: TypeMapping, 
	settings: IndexSettings | IndexStatePrefixedSettings
)

@JsonCodec case class IndexStatePrefixedSettings(
	index: IndexSettings
)
