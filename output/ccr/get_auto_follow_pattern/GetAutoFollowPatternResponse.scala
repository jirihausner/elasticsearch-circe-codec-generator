package com.converted.elasticsearch.ccr.get_auto_follow_pattern

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.ccr.get_auto_follow_pattern.{ AutoFollowPattern }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		patterns: Array[AutoFollowPattern]
	)
}

