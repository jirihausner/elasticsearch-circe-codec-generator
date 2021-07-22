package com.converted.elasticsearch.rollup.rollup

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		stubb: integer
	)
	@JsonCodec case class QueryParameters(
		stuba: integer
	)
	@JsonCodec case class Body(
		stub: integer
	)
}

