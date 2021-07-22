package com.converted.elasticsearch.cat.pending_tasks

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


@JsonCodec case class PendingTasksRecord(
	insertOrder: String, 
	timeInQueue: String, 
	priority: String, 
	source: String
)

