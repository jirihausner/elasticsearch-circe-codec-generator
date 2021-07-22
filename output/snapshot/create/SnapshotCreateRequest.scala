package com.converted.elasticsearch.snapshot.create

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Indices, Metadata, Name }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		repository: Name, 
		snapshot: Name
	)
	@JsonCodec case class QueryParameters(
		master_timeout: Time, 
		wait_for_completion: Boolean
	)
	@JsonCodec case class Body(
		ignore_unavailable: Boolean, 
		include_global_state: Boolean, 
		indices: Indices, 
		metadata: Metadata, 
		partial: Boolean
	)
}

