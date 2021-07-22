package com.converted.elasticsearch.ccr.follow_index_stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ccr._types.FollowIndexStats.{ FollowIndexStats }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		indices: Array(FollowIndexStats)
	)
}

