package com.converted.elasticsearch.enrich.get_policy

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._enrich._types.Policy.{ Summary }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		policies: Seq[Summary]
	)
}

