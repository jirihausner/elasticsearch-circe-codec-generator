package com.converted.elasticsearch.cat.help

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class HelpRecord(
	endpoint: String
)
