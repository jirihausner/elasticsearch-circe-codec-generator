package com.converted.elasticsearch.ml.get_trained_models

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		model_id: Id
	)
	@JsonCodec case class QueryParameters(
		allow_no_match: Boolean, 
		decompress_definition: Boolean, 
		exclude_generated: Boolean, 
		from: integer, 
		include: String, 
		size: integer, 
		tags: String
	)
}

