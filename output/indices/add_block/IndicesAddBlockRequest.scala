package com.converted.elasticsearch.indices.add_block

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, IndexName }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName, 
		block: IndicesBlockOptions
	)
	@JsonCodec case class QueryParameters(
		allow_no_indices: Boolean, 
		expand_wildcards: ExpandWildcards, 
		ignore_unavailable: Boolean, 
		master_timeout: Time, 
		timeout: Time
	)
	@JsonCodec case class Body(
	)
}


object IndicesBlockOptions extends Enumeration {
	type IndicesBlockOptions = Value

	val metadata = Value(0, "metadata")
	val read = Value(1, "read")
	val read_only = Value(2, "read_only")
	val write = Value(3, "write")
}

implicit val indicesBlockOptionsDecoder: Decoder[IndicesBlockOptions.Value] = Decoder.decodeEnumeration(IndicesBlockOptions)
implicit val indicesBlockOptionsEncoder: Encoder[IndicesBlockOptions.Value] = Decoder.encodeEnumeration(IndicesBlockOptions)
