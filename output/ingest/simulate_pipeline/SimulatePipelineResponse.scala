package com.converted.elasticsearch.ingest.simulate_pipeline

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.ingest.simulate_pipeline.{ PipelineSimulation }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		docs: Seq[PipelineSimulation]
	)
}

