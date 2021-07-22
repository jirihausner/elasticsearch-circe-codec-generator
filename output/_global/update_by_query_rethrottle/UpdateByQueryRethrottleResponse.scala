package com.converted.elasticsearch._global.update_by_query_rethrottle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._global.update_by_query_rethrottle.{ UpdateByQueryRethrottleNode }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		nodes: Dictionary(String, UpdateByQueryRethrottleNode)
	)
}

