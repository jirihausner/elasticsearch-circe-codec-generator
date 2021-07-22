package com.converted.elasticsearch.security._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class ManageUserPrivileges(
	applications: Seq[String]
)
