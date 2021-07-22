package com.converted.elasticsearch.indices.forcemerge

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Indices }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		flush: Boolean, 
		ignore_unavailable: Boolean, 
		max_num_segments: long, 
		only_expunge_deletes: Boolean
	)
	@JsonCodec case class Body(
	)
}

