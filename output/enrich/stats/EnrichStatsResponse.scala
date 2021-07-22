package com.converted.elasticsearch.enrich.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.enrich.stats.{ ExecutingPolicy, CoordinatorStats }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		coordinator_stats: Seq[CoordinatorStats], 
		executing_policies: Seq[ExecutingPolicy]
	)
}

