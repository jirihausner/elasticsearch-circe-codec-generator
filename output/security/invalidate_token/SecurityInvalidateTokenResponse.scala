package com.converted.elasticsearch.security.invalidate_token

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Errors.{ ErrorCause }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		error_count: long, 
		error_details: Seq[ErrorCause], 
		invalidated_tokens: long, 
		previously_invalidated_tokens: long
	)
}

