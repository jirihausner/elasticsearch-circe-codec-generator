package com.converted.elasticsearch.security.put_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Metadata, Name }

@JsonCodec case class Actions(
	actions: Array[String], 
	application: String, 
	name: Name, 
	metadata: Metadata
)
