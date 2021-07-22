package com.converted.elasticsearch.indices.delete_alias

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Indices, Names }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		name: Names
	)
	@JsonCodec case class QueryParameters(
		master_timeout: Time, 
		timeout: Time
	)
	@JsonCodec case class Body(
	)
}
