package com.converted.elasticsearch.ccr.forget_follower_index

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ IndexName, Uuid }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName
	)
	@JsonCodec case class Body(
		follower_cluster: String, 
		follower_index: IndexName, 
		follower_index_uuid: Uuid, 
		leader_remote_cluster: String
	)
}

