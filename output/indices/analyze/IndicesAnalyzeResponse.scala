package com.converted.elasticsearch.indices.analyze

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.indices.analyze.{ AnalyzeDetail, AnalyzeToken }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		detail: AnalyzeDetail, 
		tokens: Seq[AnalyzeToken]
	)
}

