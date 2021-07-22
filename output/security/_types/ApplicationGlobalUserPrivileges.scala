package com.converted.elasticsearch.security._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.security._types.{ ManageUserPrivileges }

@JsonCodec case class ApplicationGlobalUserPrivileges(
	manage: ManageUserPrivileges
)

