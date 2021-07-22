package com.converted.elasticsearch.snapshot._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ IndexName, Metadata, Name, Uuid, VersionNumber, VersionString }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }
import com.converted.elasticsearch._types.Time.{ EpochMillis, Time }
import com.converted.elasticsearch.snapshot._types.{ IndexDetails }
import com.converted.elasticsearch.snapshot._types.{ InfoFeatureState }
import com.converted.elasticsearch.snapshot._types.{ SnapshotShardFailure }

@JsonCodec case class SnapshotInfo(
	data_streams: Seq[String], 
	duration: Time, 
	duration_in_millis: EpochMillis, 
	end_time: Time, 
	end_time_in_millis: EpochMillis, 
	failures: Seq[SnapshotShardFailure], 
	include_global_state: Boolean, 
	indices: Seq[IndexName], 
	index_details: Dictionary[IndexName, IndexDetails], 
	metadata: Metadata, 
	reason: String, 
	snapshot: Name, 
	shards: ShardStatistics, 
	start_time: Time, 
	start_time_in_millis: EpochMillis, 
	state: String, 
	uuid: Uuid, 
	version: VersionString, 
	version_id: VersionNumber, 
	feature_states: Seq[InfoFeatureState]
)
