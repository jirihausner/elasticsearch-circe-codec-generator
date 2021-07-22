package com.converted.elasticsearch.ml.get_datafeeds

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Ids }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		datafeed_id: Ids
	)
	@JsonCodec case class QueryParameters(
		allow_no_datafeeds: Boolean, 
		exclude_generated: Boolean
	)
}

