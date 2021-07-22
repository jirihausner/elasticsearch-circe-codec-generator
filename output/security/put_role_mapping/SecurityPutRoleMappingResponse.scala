package com.converted.elasticsearch.security.put_role_mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.CreatedStatus.{ CreatedStatus }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		created: Boolean, 
		role_mapping: CreatedStatus
	)
}

