package com.converted.elasticsearch.security.create_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.ApplicationPrivileges.{ ApplicationPrivileges }
import com.converted.elasticsearch._types.common.{ Indices }

@JsonCodec case class RoleDescriptor(
	cluster: Seq[String], 
	index: Seq[IndexPrivileges], 
	applications: Seq[ApplicationPrivileges]
)

@JsonCodec case class IndexPrivileges(
	names: Indices, 
	privileges: Seq[String]
)
