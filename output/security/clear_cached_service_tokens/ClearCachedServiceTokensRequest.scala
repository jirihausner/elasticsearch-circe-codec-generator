package com.converted.elasticsearch.security.clear_cached_service_tokens

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Names, Namespace, Service }

@JsonCodec case class Request(
	path_parts: PathParts
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		namespace: Namespace, 
		service: Service, 
		name: Names
	)
}

