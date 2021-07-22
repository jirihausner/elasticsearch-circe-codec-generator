package com.converted.elasticsearch.security.get_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, Name, Username }

@JsonCodec case class Request(
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		id: Id, 
		name: Name, 
		owner: Boolean, 
		realm_name: Name, 
		username: Username
	)
}

