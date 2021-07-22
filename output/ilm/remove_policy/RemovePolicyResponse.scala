package com.converted.elasticsearch.ilm.remove_policy

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ IndexName }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		failed_indexes: Array[IndexName], 
		has_failures: Boolean
	)
}

