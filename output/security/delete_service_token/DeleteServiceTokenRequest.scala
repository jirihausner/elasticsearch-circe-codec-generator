package com.converted.elasticsearch.security.delete_service_token

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name, Namespace, Refresh, Service }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		namespace: Namespace, 
		service: Service, 
		name: Name
	)
	@JsonCodec case class QueryParameters(
		refresh: Refresh
	)
	@JsonCodec case class Body(
	)
}

