package com.converted.elasticsearch._global.field_caps

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ EmptyObject, ExpandWildcards, Fields, Indices }
import com.converted.elasticsearch._types.Numeric.{ integer }

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
		fields: Fields, 
		ignore_unavailable: Boolean, 
		include_unmapped: Boolean
	)
	@JsonCodec case class Body(
		index_filter: FieldCapabilitiesBodyIndexFilter
	)
}


@JsonCodec case class FieldCapabilitiesBodyIndexFilter(
	range: FieldCapabilitiesBodyIndexFilterRange, 
	match_none: EmptyObject, 
	term: FieldCapabilitiesBodyIndexFilterTerm
)

@JsonCodec case class FieldCapabilitiesBodyIndexFilterRange(
	timestamp: FieldCapabilitiesBodyIndexFilterRangeTimestamp
)

@JsonCodec case class FieldCapabilitiesBodyIndexFilterRangeTimestamp(
	gte: integer, 
	gt: integer, 
	lte: integer, 
	lt: integer
)

@JsonCodec case class FieldCapabilitiesBodyIndexFilterTerm(
	versionControl: FieldCapabilitiesBodyIndexFilterTermVersionControl
)

@JsonCodec case class FieldCapabilitiesBodyIndexFilterTermVersionControl(
	value: String
)
