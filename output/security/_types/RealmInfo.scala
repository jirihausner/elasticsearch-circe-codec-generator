package com.converted.elasticsearch.security._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class RealmInfo(
	name: Name, 
	`type`: String
)
