package com.converted.elasticsearch.security.put_user

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Metadata, Password, Refresh, Username }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		username: Username
	)
	@JsonCodec case class QueryParameters(
		refresh: Refresh
	)
	@JsonCodec case class Body(
		username: Username, 
		email: String | null, 
		full_name: String | null, 
		metadata: Metadata, 
		password: Password, 
		password_hash: String, 
		roles: Array(String), 
		enabled: Boolean
	)
}

