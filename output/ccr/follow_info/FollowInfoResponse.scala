package com.converted.elasticsearch.ccr.follow_info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.ccr.follow_info.{ FollowerIndex }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		follower_indices: Seq[FollowerIndex]
	)
}

