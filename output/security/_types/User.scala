package com.converted.elasticsearch.security._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Metadata, Name, Username }

@JsonCodec case class User(
	email: String, 
	full_name: Name, 
	metadata: Metadata, 
	roles: Seq[String], 
	username: Username, 
	enabled: Boolean
)
