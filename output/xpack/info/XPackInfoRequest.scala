package com.converted.elasticsearch.xpack.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }

@JsonCodec case class Request(
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		categories: Array(String)
	)
}

