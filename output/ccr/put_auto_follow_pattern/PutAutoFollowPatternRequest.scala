package com.converted.elasticsearch.ccr.put_auto_follow_pattern

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ ByteSize, IndexPattern, IndexPatterns, Name }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		name: Name
	)
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
		remote_cluster: String, 
		follow_index_pattern: IndexPattern, 
		leader_index_patterns: IndexPatterns, 
		max_outstanding_read_requests: integer, 
		settings: Dictionary[String, UserDefinedValue], 
		max_outstanding_write_requests: integer, 
		read_poll_timeout: Time, 
		max_read_request_operation_count: integer, 
		max_read_request_size: ByteSize, 
		max_retry_delay: Time, 
		max_write_buffer_count: integer, 
		max_write_buffer_size: ByteSize, 
		max_write_request_operation_count: integer, 
		max_write_request_size: ByteSize
	)
}

