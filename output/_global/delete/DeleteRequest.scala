package com.converted.elasticsearch._global.delete

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, IndexName, Refresh, Routing, SequenceNumber, Type, VersionNumber, VersionType, WaitForActiveShards }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id, 
		index: IndexName, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		if_primary_term: Long, 
		if_seq_no: SequenceNumber, 
		refresh: Refresh, 
		routing: Routing, 
		timeout: Time, 
		version: VersionNumber, 
		version_type: VersionType, 
		wait_for_active_shards: WaitForActiveShards
	)
	@JsonCodec case class Body(
	)
}

