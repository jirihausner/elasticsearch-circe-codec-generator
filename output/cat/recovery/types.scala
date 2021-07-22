package com.converted.elasticsearch.cat.recovery

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ IndexName, Type }
import com.converted.elasticsearch._types.Numeric.{ Percentage }

@JsonCodec case class RecoveryRecord(
	index: IndexName, 
	shard: String, 
	start_time: String, 
	start_time_millis: String, 
	stop_time: String, 
	stop_time_millis: String, 
	time: String, 
	`type`: Type, 
	stage: String, 
	source_host: String, 
	source_node: String, 
	target_host: String, 
	target_node: String, 
	repository: String, 
	snapshot: String, 
	files: String, 
	files_recovered: String, 
	files_percent: Percentage, 
	files_total: String, 
	bytes: String, 
	bytes_recovered: String, 
	bytes_percent: Percentage, 
	bytes_total: String, 
	translog_ops: String, 
	translog_ops_recovered: String, 
	translog_ops_percent: Percentage
)

