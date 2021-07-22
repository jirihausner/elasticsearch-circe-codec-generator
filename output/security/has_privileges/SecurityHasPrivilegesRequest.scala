package com.converted.elasticsearch.security.has_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch.security.has_privileges.{ ApplicationPrivilegesCheck, IndexPrivilegesCheck }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		user: Name
	)
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
		application: Array[ApplicationPrivilegesCheck], 
		cluster: Array[String], 
		index: Array[IndexPrivilegesCheck]
	)
}

