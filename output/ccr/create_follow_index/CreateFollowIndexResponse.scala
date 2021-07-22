package com.converted.elasticsearch.ccr.create_follow_index

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		follow_index_created: Boolean, 
		follow_index_shards_acked: Boolean, 
		index_following_started: Boolean
	)
}

