package com.converted.elasticsearch._global.clear_scroll

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Ids }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		scroll_id: Ids
	)
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
		scroll_id: Ids
	)
}

