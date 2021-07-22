package com.converted.elasticsearch.security.get_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, Metadata, Name, Username }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class ApiKey(
	creation: Long, 
	expiration: Long, 
	id: Id, 
	invalidated: Boolean, 
	name: Name, 
	realm: String, 
	username: Username, 
	metadata: Metadata
)

