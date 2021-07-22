package com.converted.elasticsearch.cat.allocation

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cat._types.CatBase.{ CatRequestBase }
import com.converted.elasticsearch._types.common.{ Bytes, NodeIds }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends CatRequestBase

object Request {
	@JsonCodec case class PathParts(
		node_id: NodeIds
	)
	@JsonCodec case class QueryParameters(
		bytes: Bytes
	)
	@JsonCodec case class Body(
	)
}

