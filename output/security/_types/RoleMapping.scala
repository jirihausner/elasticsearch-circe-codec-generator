package com.converted.elasticsearch.security._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Metadata }
import com.converted.elasticsearch.security._types.{ RoleMappingRuleBase }

@JsonCodec case class RoleMapping(
	enabled: Boolean, 
	metadata: Metadata, 
	roles: Array(String), 
	rules: RoleMappingRuleBase
)
