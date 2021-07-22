package com.converted.elasticsearch.license.post_start_trial

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }

@JsonCodec case class Request(
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		acknowledge: Boolean, 
		type_query_string: String
	)
}

