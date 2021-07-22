package com.converted.elasticsearch.cat.data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, IndexName, Name, Type, VersionString }

@JsonCodec case class DataFrameAnalyticsRecord(
	id: Id, 
	`type`: Type, 
	create_time: String, 
	version: VersionString, 
	source_index: IndexName, 
	dest_index: IndexName, 
	description: String, 
	model_memory_limit: String, 
	state: String, 
	failure_reason: String, 
	progress: String, 
	assignment_explanation: String, 
	`node.id`: Id, 
	`node.name`: Name, 
	`node.ephemeral_id`: Id, 
	`node.address`: String
)

