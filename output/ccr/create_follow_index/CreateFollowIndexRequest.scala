package com.converted.elasticsearch.ccr.create_follow_index

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ IndexName, WaitForActiveShards }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName
	)
	@JsonCodec case class QueryParameters(
		wait_for_active_shards: WaitForActiveShards
	)
	@JsonCodec case class Body(
		leader_index: IndexName, 
		max_outstanding_read_requests: long, 
		max_outstanding_write_requests: long, 
		max_read_request_operation_count: long, 
		max_read_request_size: String, 
		max_retry_delay: Time, 
		max_write_buffer_count: long, 
		max_write_buffer_size: String, 
		max_write_request_operation_count: long, 
		max_write_request_size: String, 
		read_poll_timeout: Time, 
		remote_cluster: String
	)
}

