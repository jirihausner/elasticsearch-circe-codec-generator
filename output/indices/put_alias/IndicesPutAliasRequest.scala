package com.converted.elasticsearch.indices.put_alias

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Indices, Name, Routing }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		name: Name
	)
	@JsonCodec case class QueryParameters(
		master_timeout: Time, 
		timeout: Time
	)
	@JsonCodec case class Body(
		filter: QueryContainer, 
		index_routing: Routing, 
		is_write_index: Boolean, 
		routing: Routing, 
		search_routing: Routing
	)
}

