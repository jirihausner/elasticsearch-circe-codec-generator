package com.converted.elasticsearch.security.has_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class ApplicationPrivilegesCheck(
	application: String, 
	privileges: Array[String], 
	resources: Array[String]
)

@JsonCodec case class IndexPrivilegesCheck(
	names: Array[String], 
	privileges: Array[String]
)
type ApplicationsPrivileges = Dictionary[Name, ResourcePrivileges]
type ResourcePrivileges = Dictionary[Name, Privileges]
type Privileges = Dictionary[String, Boolean]
