package com.converted.elasticsearch._global.search_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Id, Indices, Routing, SearchType, Types }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices, 
		`type`: Types
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		ccs_minimize_roundtrips: Boolean, 
		expand_wildcards: ExpandWildcards, 
		explain: Boolean, 
		ignore_throttled: Boolean, 
		ignore_unavailable: Boolean, 
		preference: String, 
		profile: Boolean, 
		routing: Routing, 
		scroll: Time, 
		search_type: SearchType, 
		total_hits_as_integer: Boolean, 
		typed_keys: Boolean
	)
	@JsonCodec case class Body(
		id: Id, 
		params: Dictionary[String, UserDefinedValue], 
		source: String
	)
}

