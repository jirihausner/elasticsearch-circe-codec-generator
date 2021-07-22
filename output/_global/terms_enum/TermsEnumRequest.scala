package com.converted.elasticsearch._global.terms_enum

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Field, IndexName }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName
	)
	@JsonCodec case class Body(
		field: Field, 
		size: integer, 
		timeout: Time, 
		case_insensitive: Boolean, 
		index_filter: QueryContainer, 
		string: String, 
		search_after: String
	)
}

