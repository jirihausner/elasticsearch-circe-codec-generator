package com.converted.elasticsearch.security.get_user_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Request(
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		application: Name, 
		priviledge: Name
	)
}

