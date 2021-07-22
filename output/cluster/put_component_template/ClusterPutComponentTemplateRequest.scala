package com.converted.elasticsearch.cluster.put_component_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.AliasDefinition.{ AliasDefinition }
import com.converted.elasticsearch._indices._types.IndexSettings.{ IndexSettings }
import com.converted.elasticsearch._indices._types.IndexState.{ IndexState }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Metadata, Name, VersionNumber }
import com.converted.elasticsearch._types.mapping.TypeMapping.{ TypeMapping }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Name
	)
	@JsonCodec case class QueryParameters(
		create: Boolean, 
		master_timeout: Time
	)
	@JsonCodec case class Body(
		template: IndexState, 
		aliases: Dictionary[String, AliasDefinition], 
		mappings: TypeMapping, 
		settings: IndexSettings, 
		version: VersionNumber, 
		_meta: Metadata
	)
}

