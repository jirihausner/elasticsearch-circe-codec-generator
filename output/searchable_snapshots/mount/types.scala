package com.converted.elasticsearch.searchable_snapshots.mount

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Indices, Name }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }

@JsonCodec case class MountedSnapshot(
	snapshot: Name, 
	indices: Indices, 
	shards: ShardStatistics
)

