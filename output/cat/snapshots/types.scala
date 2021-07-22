package com.converted.elasticsearch.cat.snapshots

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Time.{ DateString, EpochMillis, Time }

@JsonCodec case class SnapshotsRecord(
	id: String, 
	repository: String, 
	status: String, 
	start_epoch: EpochMillis, 
	start_time: DateString, 
	end_epoch: EpochMillis, 
	end_time: DateString, 
	duration: Time, 
	indices: String, 
	successful_shards: String, 
	failed_shards: String, 
	total_shards: String, 
	reason: String
)
