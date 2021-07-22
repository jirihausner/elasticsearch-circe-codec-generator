package com.converted.elasticsearch.security.create_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.ApplicationPrivileges.{ ApplicationPrivileges }
import com.converted.elasticsearch._types.common.{ Indices }

@JsonCodec case class RoleDescriptor(
	cluster: Array[String], 
	index: Array[IndexPrivileges], 
	applications: Array[ApplicationPrivileges]
)

@JsonCodec case class IndexPrivileges(
	names: Indices, 
	privileges: Array[String]
)
