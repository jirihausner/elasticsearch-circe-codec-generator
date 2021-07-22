package com.converted.elasticsearch.ml.put_trained_model

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		stub: String
	)
	@JsonCodec case class QueryParameters(
		stub: String
	)
	@JsonCodec case class Body(
		stub: String
	)
}

