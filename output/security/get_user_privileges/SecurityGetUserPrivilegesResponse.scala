package com.converted.elasticsearch.security.get_user_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.ApplicationPrivileges.{ ApplicationPrivileges }
import com.converted.elasticsearch._security._types.GlobalPrivileges.{ GlobalPrivileges }
import com.converted.elasticsearch._security._types.IndicesPrivileges.{ IndicesPrivileges }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		applications: Seq[ApplicationPrivileges], 
		cluster: Seq[String], 
		global: Seq[GlobalPrivileges], 
		indices: Seq[IndicesPrivileges], 
		run_as: Seq[String]
	)
}

