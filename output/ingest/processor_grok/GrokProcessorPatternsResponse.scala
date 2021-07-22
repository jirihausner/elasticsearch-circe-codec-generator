package com.converted.elasticsearch.ingest.processor_grok

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		patterns: Dictionary(String, String)
	)
}

