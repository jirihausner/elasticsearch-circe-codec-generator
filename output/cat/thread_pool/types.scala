package com.converted.elasticsearch.cat.thread_pool

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ NodeId }

@JsonCodec case class ThreadPoolRecord(
	node_name: String, 
	node_id: NodeId, 
	ephemeral_node_id: String, 
	pid: String, 
	host: String, 
	ip: String, 
	port: String, 
	name: String, 
	`type`: String, 
	active: String, 
	pool_size: String, 
	queue: String, 
	queue_size: String, 
	rejected: String, 
	largest: String, 
	completed: String, 
	core: String, 
	max: String, 
	size: String, 
	keep_alive: String
)

