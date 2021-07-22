package com.converted.elasticsearch.rollup.get_rollup_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.rollup.get_rollup_job.{ RollupJob }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		jobs: Array(RollupJob)
	)
}

