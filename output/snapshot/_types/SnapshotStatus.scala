package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Uuid }
import com.converted.elasticsearch.snapshot._types.{ SnapshotIndexStats }
import com.converted.elasticsearch.snapshot._types.{ ShardsStats }
import com.converted.elasticsearch.snapshot._types.{ SnapshotStats }

@JsonCodec case class Status(
	include_global_state: Boolean, 
	indices: Dictionary(String, SnapshotIndexStats), 
	repository: String, 
	shards_stats: ShardsStats, 
	snapshot: String, 
	state: String, 
	stats: SnapshotStats, 
	uuid: Uuid
)

