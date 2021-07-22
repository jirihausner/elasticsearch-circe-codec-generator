package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch.snapshot._types.{ ShardsStats }
import com.converted.elasticsearch.snapshot._types.{ SnapshotShardsStatus }
import com.converted.elasticsearch.snapshot._types.{ SnapshotStats }

@JsonCodec case class SnapshotIndexStats(
	shards: Dictionary(String, SnapshotShardsStatus), 
	shards_stats: ShardsStats, 
	stats: SnapshotStats
)

