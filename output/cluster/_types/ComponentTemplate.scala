package com.converted.elasticsearch.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.AliasDefinition.{ AliasDefinition }
import com.converted.elasticsearch._indices._types.IndexSettings.{ IndexSettings }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ IndexName, Metadata, Name, VersionNumber }
import com.converted.elasticsearch._types.mapping.TypeMapping.{ TypeMapping }

@JsonCodec case class ComponentTemplate(
	name: Name, 
	component_template: ComponentTemplateNode
)


@JsonCodec case class ComponentTemplateNode(
	template: ComponentTemplateSummary, 
	version: VersionNumber, 
	_meta: Metadata
)


@JsonCodec case class ComponentTemplateSummary(
	_meta: Metadata, 
	version: VersionNumber, 
	settings: Dictionary(IndexName, IndexSettings), 
	mappings: TypeMapping, 
	aliases: Dictionary(String, AliasDefinition)
)

