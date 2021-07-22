package com.converted.elasticsearch.security.put_role_mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.RoleMappingRuleBase.{ RoleMappingRuleBase }
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
		enabled: Boolean, 
		metadata: Metadata, 
		roles: Seq[String], 
		rules: RoleMappingRuleBase, 
		run_as: Seq[String]
	)
}

