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
		error_count: Long, 
		error_details: Array(ErrorCause), 
		invalidated_tokens: Long, 
		previously_invalidated_tokens: Long
	)
}

