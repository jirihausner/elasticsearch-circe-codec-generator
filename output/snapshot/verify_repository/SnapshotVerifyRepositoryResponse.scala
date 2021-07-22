package com.converted.elasticsearch.snapshot.verify_repository

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		nodes: Dictionary(String, CompactNodeInfo)
	)
}


@JsonCodec case class CompactNodeInfo(
	name: Name
)

