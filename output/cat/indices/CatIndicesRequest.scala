package com.converted.elasticsearch.cat.indices

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cat._types.CatBase.{ CatRequestBase }
import com.converted.elasticsearch._types.common.{ Bytes, ExpandWildcards, Health, Indices }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends CatRequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices
	)
	@JsonCodec case class QueryParameters(
		bytes: Bytes, 
		expand_wildcards: ExpandWildcards, 
		health: Health, 
		include_unloaded_segments: Boolean, 
		pri: Boolean
	)
	@JsonCodec case class Body(
	)
}

