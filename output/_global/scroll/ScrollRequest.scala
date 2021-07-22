package com.converted.elasticsearch._global.scroll

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, ScrollId }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		scroll_id: Id
	)
	@JsonCodec case class QueryParameters(
		scroll: Time, 
		scroll_id: ScrollId, 
		rest_total_hits_as_int: Boolean, 
		total_hits_as_integer: Boolean
	)
	@JsonCodec case class Body(
		scroll: Time, 
		scroll_id: ScrollId, 
		rest_total_hits_as_int: Boolean
	)
}

