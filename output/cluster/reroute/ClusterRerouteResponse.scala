package com.converted.elasticsearch.cluster.reroute

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ AcknowledgedResponseBase }
import com.converted.elasticsearch.cluster.reroute.{ RerouteExplanation, RerouteState }

@JsonCodec case class Response(
	body: Body
) extends AcknowledgedResponseBase

object Response {
	@JsonCodec case class Body(
		explanations: Array(RerouteExplanation), 
		state: RerouteState
	)
}

