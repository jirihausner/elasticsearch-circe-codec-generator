package com.converted.elasticsearch.security.put_role

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security.get_role.types.{ TransientMetadata }
import com.converted.elasticsearch._security._types.ApplicationPrivileges.{ ApplicationPrivileges }
import com.converted.elasticsearch._security._types.IndicesPrivileges.{ IndicesPrivileges }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Metadata, Name, Refresh }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Name
	)
	@JsonCodec case class QueryParameters(
		refresh: Refresh
	)
	@JsonCodec case class Body(
		applications: Array[ApplicationPrivileges], 
		cluster: Array[String], 
		global: Dictionary[String, UserDefinedValue], 
		indices: Array[IndicesPrivileges], 
		metadata: Metadata, 
		run_as: Array[String], 
		transient_metadata: TransientMetadata
	)
}

