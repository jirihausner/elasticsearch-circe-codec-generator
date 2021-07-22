package com.converted.elasticsearch.indices.get_index_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.Alias.{ Alias }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ IndexName, Metadata, Name, VersionNumber }
import com.converted.elasticsearch._types.mapping.TypeMapping.{ TypeMapping }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		index_templates: Array[IndexTemplateItem]
	)
}


@JsonCodec case class IndexTemplateItem(
	name: Name, 
	index_template: IndexTemplate
)

@JsonCodec case class IndexTemplate(
	index_patterns: Array[Name], 
	composed_of: Array[Name], 
	template: IndexTemplateSummary, 
	version: VersionNumber, 
	priority: long, 
	_meta: Metadata, 
	allow_auto_create: Boolean, 
	data_stream: Dictionary[String, UserDefinedValue]
)

@JsonCodec case class IndexTemplateSummary(
	aliases: Dictionary[IndexName, Alias], 
	mappings: TypeMapping, 
	settings: Dictionary[String, UserDefinedValue]
)
