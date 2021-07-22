package com.converted.elasticsearch.security.has_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ IndexName, Username }
import com.converted.elasticsearch.security.has_privileges.{ ApplicationsPrivileges, Privileges }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		application: ApplicationsPrivileges, 
		cluster: Dictionary[String, Boolean], 
		has_all_requested: Boolean, 
		index: Dictionary[IndexName, Privileges], 
		username: Username
	)
}

