package com.converted.elasticsearch._global.mget

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Fields, IndexName, Routing, Type }
import com.converted.elasticsearch._global.mget.{ MultiGetId, Operation }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		preference: String, 
		realtime: Boolean, 
		refresh: Boolean, 
		routing: Routing, 
		_source: Boolean | Fields, 
		_source_excludes: Fields, 
		_source_includes: Fields, 
		stored_fields: Fields
	)
	@JsonCodec case class Body(
		docs: Array(Operation), 
		ids: Array(MultiGetId)
	)
}

