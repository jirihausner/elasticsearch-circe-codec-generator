package com.converted.elasticsearch.security.invalidate_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Errors.{ ErrorCause }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		error_count: integer, 
		error_details: Seq[ErrorCause], 
		invalidated_api_keys: Seq[String], 
		previously_invalidated_api_keys: Seq[String]
	)
}

