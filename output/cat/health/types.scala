package com.converted.elasticsearch.cat.health

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Time.{ DateString, EpochMillis }

@JsonCodec case class HealthRecord(
	epoch: EpochMillis, 
	timestamp: DateString, 
	cluster: String, 
	status: String, 
	`node.total`: String, 
	`node.data`: String, 
	shards: String, 
	pri: String, 
	relo: String, 
	init: String, 
	unassign: String, 
	pending_tasks: String, 
	max_task_wait_time: String, 
	active_shards_percent: String
)

