package com.converted.elasticsearch._global.reindex_rethrottle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.BaseNode.{ BaseNode }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ HttpHeaders, Name, TaskId }
import com.converted.elasticsearch._types.Numeric.{ float, long }
import com.converted.elasticsearch._types.Retries.{ Retries }

@JsonCodec case class ReindexNode(
	tasks: Dictionary(TaskId, ReindexTask)
) extends BaseNode


@JsonCodec case class ReindexStatus(
	batches: Long, 
	created: Long, 
	deleted: Long, 
	noops: Long, 
	requests_per_second: float, 
	retries: Retries, 
	throttled_millis: Long, 
	throttled_until_millis: Long, 
	total: Long, 
	updated: Long, 
	version_conflicts: Long
)


@JsonCodec case class ReindexTask(
	action: String, 
	cancellable: Boolean, 
	description: String, 
	id: Long, 
	node: Name, 
	running_time_in_nanos: Long, 
	start_time_in_millis: Long, 
	status: ReindexStatus, 
	`type`: String, 
	headers: HttpHeaders
)

