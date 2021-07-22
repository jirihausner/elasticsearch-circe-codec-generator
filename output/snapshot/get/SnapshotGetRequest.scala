package com.converted.elasticsearch.snapshot.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name, Names }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		repository: Name, 
		snapshot: Names
	)
	@JsonCodec case class QueryParameters(
		ignore_unavailable: Boolean, 
		master_timeout: Time, 
		verbose: Boolean, 
		index_details: Boolean, 
		human: Boolean
	)
}

