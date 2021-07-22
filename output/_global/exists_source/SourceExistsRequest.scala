package com.converted.elasticsearch._global.exists_source

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Fields, Id, IndexName, Routing, Type, VersionNumber, VersionType }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
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
		source_excludes: Fields, 
		source_includes: Fields, 
		version: VersionNumber, 
		version_type: VersionType
	)
	@JsonCodec case class Body(
	)
}

