package com.converted.elasticsearch.indices.put_index_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.Alias.{ Alias }
import com.converted.elasticsearch._indices._types.IndexSettings.{ IndexSettings }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ EmptyObject, IndexName, Indices, Metadata, Name, VersionNumber }
import com.converted.elasticsearch._types.mapping.TypeMapping.{ TypeMapping }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Name
	)
	@JsonCodec case class Body(
		index_patterns: Indices, 
		composed_of: Array[Name], 
		template: IndexTemplateMapping, 
		data_stream: EmptyObject, 
		priority: integer, 
		version: VersionNumber, 
		_meta: Metadata
	)
}


@JsonCodec case class IndexTemplateMapping(
	aliases: Dictionary[IndexName, Alias], 
	mappings: TypeMapping, 
	settings: IndexSettings
)
