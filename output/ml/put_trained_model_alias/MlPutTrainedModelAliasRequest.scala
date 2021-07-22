package com.converted.elasticsearch.ml.put_trained_model_alias

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		model_alias: String, 
		model_id: Id
	)
	@JsonCodec case class QueryParameters(
		reassign: Boolean
	)
}

