package com.converted.elasticsearch.ml.update_filter

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		description: String, 
		filter_id: Id, 
		items: Array(String)
	)
}

