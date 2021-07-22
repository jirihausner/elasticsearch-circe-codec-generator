package com.converted.elasticsearch.security.get_service_accounts

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.ApplicationPrivileges.{ ApplicationPrivileges }
import com.converted.elasticsearch._security._types.GlobalPrivileges.{ GlobalPrivileges }
import com.converted.elasticsearch._security._types.IndicesPrivileges.{ IndicesPrivileges }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Metadata }

@JsonCodec case class RoleDescriptorWrapper(
	role_descriptor: RoleDescriptor
)

@JsonCodec case class RoleDescriptor(
	cluster: Seq[String], 
	indices: Seq[IndicesPrivileges], 
	global: Seq[GlobalPrivileges], 
	applications: Seq[ApplicationPrivileges], 
	metadata: Metadata, 
	run_as: Seq[String], 
	transient_metadata: Dictionary[String, UserDefinedValue]
)
