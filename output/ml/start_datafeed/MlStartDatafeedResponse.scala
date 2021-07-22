package com.converted.elasticsearch.ml.start_datafeed

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ NodeIds }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		node: NodeIds, 
		started: Boolean
	)
}

