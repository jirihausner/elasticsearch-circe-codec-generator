package com.converted.elasticsearch.ml.start_datafeed

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		datafeed_id: Id
	)
	@JsonCodec case class QueryParameters(
		start: Time
	)
	@JsonCodec case class Body(
		end: Time, 
		start: Time, 
		timeout: Time
	)
}

