package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, IndexName }

@JsonCodec case class SnapshotShardFailure(
	index: IndexName, 
	node_id: Id, 
	reason: String, 
	shard_id: Id, 
	status: String
)
