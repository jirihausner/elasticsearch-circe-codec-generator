package com.converted.elasticsearch.cluster.health

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ExpandWildcards, Indices, Level, WaitForActiveShards, WaitForEvents, WaitForStatus }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: Indices
	)
	@JsonCodec case class QueryParameters(
		expand_wildcards: ExpandWildcards, 
		level: Level, 
		local: Boolean, 
		master_timeout: Time, 
		timeout: Time, 
		wait_for_active_shards: WaitForActiveShards, 
		wait_for_events: WaitForEvents, 
		wait_for_nodes: String, 
		wait_for_no_initializing_shards: Boolean, 
		wait_for_no_relocating_shards: Boolean, 
		wait_for_status: WaitForStatus
	)
}

