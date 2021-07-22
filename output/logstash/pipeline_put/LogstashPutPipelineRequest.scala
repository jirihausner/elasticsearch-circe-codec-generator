package com.converted.elasticsearch.logstash.pipeline_put

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
		stub_a: String
	)
	@JsonCodec case class QueryParameters(
		stub_b: String
	)
	@JsonCodec case class Body(
		stub_c: String
	)
}

