package com.converted.elasticsearch.enrich.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._task._types.TaskInfo.{ Info }
import com.converted.elasticsearch._types.common.{ Id, Name }
import com.converted.elasticsearch._types.Numeric.{ integer, long }

@JsonCodec case class ExecutingPolicy(
	name: Name, 
	task: Info
)

@JsonCodec case class CoordinatorStats(
	executed_searches_total: long, 
	node_id: Id, 
	queue_size: integer, 
	remote_requests_current: integer, 
	remote_requests_total: long
)
