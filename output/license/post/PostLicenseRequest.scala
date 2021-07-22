package com.converted.elasticsearch.license.post

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._license._types.License.{ License }
import com.converted.elasticsearch._types.Base.{ RequestBase }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		acknowledge: Boolean
	)
	@JsonCodec case class Body(
		license: License, 
		licenses: Array(License)
	)
}

