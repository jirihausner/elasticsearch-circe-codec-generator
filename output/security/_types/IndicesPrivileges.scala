package com.converted.elasticsearch.security._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.FieldSecurity.{ FieldSecurity }
import com.converted.elasticsearch._types.common.{ Indices }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class IndicesPrivileges(
	field_security: FieldSecurity, 
	names: Indices, 
	privileges: Array(String), 
	query: String | QueryContainer, 
	allow_restricted_indices: Boolean
)

