package com.converted.elasticsearch.security._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class ApplicationPrivileges(
	application: String, 
	privileges: Array(String), 
	resources: Array(String)
)

