package com.converted.elasticsearch.indices.exists

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.VoidValue.{ Void }

@JsonCodec case class Response(
	body: Void
)

