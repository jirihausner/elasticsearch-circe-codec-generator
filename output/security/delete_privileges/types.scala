package com.converted.elasticsearch.security.delete_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class FoundStatus(
	found: Boolean
)
