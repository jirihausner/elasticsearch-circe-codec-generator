package com.converted.elasticsearch._global.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Fields, Id, IndexName, Routing, Type, VersionNumber, VersionType }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id, 
		index: IndexName, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		preference: String, 
		realtime: Boolean, 
		refresh: Boolean, 
		routing: Routing, 
		source_enabled: Boolean, 
		_source_excludes: Fields, 
		_source_includes: Fields, 
		stored_fields: Fields, 
		version: VersionNumber, 
		version_type: VersionType, 
		_source: Boolean | Fields
	)
}

