package com.converted.elasticsearch.cat.nodes

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cat._types.CatBase.{ CatRequestBase }
import com.converted.elasticsearch._types.common.{ Bytes }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends CatRequestBase

object Request {
	@JsonCodec case class QueryParameters(
		bytes: Bytes, 
		full_id: Boolean | String
	)
	@JsonCodec case class Body(
	)
}

