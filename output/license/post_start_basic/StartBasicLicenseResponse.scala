package com.converted.elasticsearch.license.post_start_basic

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ AcknowledgedResponseBase }

@JsonCodec case class Response(
	body: Body
) extends AcknowledgedResponseBase

object Response {
	@JsonCodec case class Body(
		acknowledge: Dictionary(String, String | Array(String)), 
		basic_was_started: Boolean, 
		error_message: String
	)
}

