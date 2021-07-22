package com.converted.elasticsearch._global.termvectors

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Field, Fields, Id, IndexName, Routing, Type, VersionNumber, VersionType }
import com.converted.elasticsearch._global.termvectors.{ Filter }

@JsonCodec case class Request[TDocument](
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName, 
		id: Id, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		fields: Fields, 
		field_statistics: Boolean, 
		offsets: Boolean, 
		payloads: Boolean, 
		positions: Boolean, 
		preference: String, 
		realtime: Boolean, 
		routing: Routing, 
		term_statistics: Boolean, 
		version: VersionNumber, 
		version_type: VersionType
	)
	@JsonCodec case class Body(
		doc: TDocument, 
		filter: Filter, 
		per_field_analyzer: Dictionary(Field, String)
	)
}

