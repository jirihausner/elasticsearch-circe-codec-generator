package com.converted.elasticsearch.cluster.pending_tasks

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class PendingTask(
	insert_order: integer, 
	priority: String, 
	source: String, 
	time_in_queue: String, 
	time_in_queue_millis: integer
)
