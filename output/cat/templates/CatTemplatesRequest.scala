package com.converted.elasticsearch.cat.templates

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cat._types.CatBase.{ CatRequestBase }
import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends CatRequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Name
	)
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
	)
}

