package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.{ long }

@JsonCodec case class Retries(
	bulk: long, 
	search: long
)

