package com.converted.elasticsearch.ccr.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.ccr.stats.{ AutoFollowStats, FollowStats }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		auto_follow_stats: AutoFollowStats, 
		follow_stats: FollowStats
	)
}

