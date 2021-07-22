package com.converted.elasticsearch.ccr.follow_info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ IndexName, Name }

@JsonCodec case class FollowerIndex(
	follower_index: IndexName, 
	leader_index: IndexName, 
	parameters: FollowerIndexParameters, 
	remote_cluster: Name, 
	status: FollowerIndexStatus
)


object FollowerIndexStatus extends Enumeration {
	type FollowerIndexStatus = Value

val active = Value(0, "active")
val paused = Value(1, "paused")
}

implicit val followerIndexStatusDecoder: Decoder[FollowerIndexStatus.Value] = Decoder.decodeEnumeration(FollowerIndexStatus)
implicit val followerIndexStatusEncoder: Encoder[FollowerIndexStatus.Value] = Decoder.encodeEnumeration(FollowerIndexStatus)

import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class FollowerIndexParameters(
	max_outstanding_read_requests: integer, 
	max_outstanding_write_requests: integer, 
	max_read_request_operation_count: integer, 
	max_read_request_size: String, 
	max_retry_delay: Time, 
	max_write_buffer_count: integer, 
	max_write_buffer_size: String, 
	max_write_request_operation_count: integer, 
	max_write_request_size: String, 
	read_poll_timeout: Time
)

