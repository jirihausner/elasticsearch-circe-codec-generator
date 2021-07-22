package com.converted.elasticsearch.cat.trained_models

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cat._types.CatBase.{ CatRequestBase }
import com.converted.elasticsearch._types.common.{ Bytes, Id }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends CatRequestBase

object Request {
	@JsonCodec case class PathParts(
		model_id: Id
	)
	@JsonCodec case class QueryParameters(
		allow_no_match: Boolean, 
		bytes: Bytes, 
		from: integer, 
		size: integer
	)
	@JsonCodec case class Body(
	)
}

