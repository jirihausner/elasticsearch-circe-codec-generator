package com.converted.elasticsearch.security.has_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class ApplicationPrivilegesCheck(
	application: String, 
	privileges: Seq[String], 
	resources: Seq[String]
)

@JsonCodec case class IndexPrivilegesCheck(
	names: Seq[String], 
	privileges: Seq[String]
)
type ApplicationsPrivileges = Dictionary[Name, ResourcePrivileges]
type ResourcePrivileges = Dictionary[Name, Privileges]
type Privileges = Dictionary[String, Boolean]
