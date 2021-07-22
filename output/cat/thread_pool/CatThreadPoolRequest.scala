package com.converted.elasticsearch.cat.thread_pool

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cat._types.CatBase.{ CatRequestBase }
import com.converted.elasticsearch._types.common.{ Names, Size }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends CatRequestBase

object Request {
	@JsonCodec case class PathParts(
		thread_pool_patterns: Names
	)
	@JsonCodec case class QueryParameters(
		size: Size | Boolean
	)
	@JsonCodec case class Body(
	)
}

