package com.converted.elasticsearch.cat.tasks

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, NodeId, Type, VersionString }

@JsonCodec case class TasksRecord(
	id: Id, 
	action: String, 
	task_id: Id, 
	parent_task_id: String, 
	`type`: Type, 
	start_time: String, 
	timestamp: String, 
	running_time_ns: String, 
	running_time: String, 
	node_id: NodeId, 
	ip: String, 
	port: String, 
	node: String, 
	version: VersionString, 
	x_opaque_id: String, 
	description: String
)
