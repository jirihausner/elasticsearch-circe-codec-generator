package com.converted.elasticsearch._global.msearch_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Indices, SearchType, Types }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._global.msearch_template.{ TemplateItem }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Array(TemplateItem)
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		`type`: Types
	)
	@JsonCodec case class QueryParameters(
		ccs_minimize_roundtrips: Boolean, 
		max_concurrent_searches: long, 
		search_type: SearchType, 
		rest_total_hits_as_int: Boolean, 
		typed_keys: Boolean
	)
}

