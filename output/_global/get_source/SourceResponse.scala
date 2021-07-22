package com.converted.elasticsearch._global.get_source

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class Response[TDocument](
	body: TDocument
)
