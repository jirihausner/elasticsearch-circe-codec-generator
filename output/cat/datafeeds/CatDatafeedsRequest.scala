package com.converted.elasticsearch.cat.datafeeds

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cat._types.CatBase.{ CatRequestBase }
import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends CatRequestBase

object Request {
	@JsonCodec case class PathParts(
		datafeed_id: Id
	)
	@JsonCodec case class QueryParameters(
		allow_no_datafeeds: Boolean
	)
	@JsonCodec case class Body(
	)
}

