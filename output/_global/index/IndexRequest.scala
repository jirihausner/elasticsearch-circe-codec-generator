package com.converted.elasticsearch._global.index

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, IndexName, OpType, Refresh, Routing, SequenceNumber, Type, VersionNumber, VersionType, WaitForActiveShards }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request[TDocument](
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: TDocument
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id, 
		index: IndexName, 
		`type`: Type
	)
	@JsonCodec case class QueryParameters(
		if_primary_term: long, 
		if_seq_no: SequenceNumber, 
		op_type: OpType, 
		pipeline: String, 
		refresh: Refresh, 
		routing: Routing, 
		timeout: Time, 
		version: VersionNumber, 
		version_type: VersionType, 
		wait_for_active_shards: WaitForActiveShards, 
		require_alias: Boolean
	)
}

