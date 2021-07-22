package com.converted.elasticsearch.snapshot.restore

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		snapshot: SnapshotRestore
	)
}


@JsonCodec case class SnapshotRestore(
	indices: Array(IndexName), 
	snapshot: String, 
	shards: ShardStatistics
)

