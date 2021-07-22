package com.converted.elasticsearch._global.mtermvectors

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.mtermvectors.{ TermVectorsResult }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		docs: Array[TermVectorsResult]
	)
}

