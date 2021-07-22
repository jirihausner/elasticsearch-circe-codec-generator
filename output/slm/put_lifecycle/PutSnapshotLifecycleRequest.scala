package com.converted.elasticsearch.slm.put_lifecycle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._slm._types.SnapshotLifecycle.{ Configuration, Retention }
import com.converted.elasticsearch._watcher._types.Schedule.{ CronExpression }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		policy_id: Name
	)
	@JsonCodec case class Body(
		config: Configuration, 
		name: Name, 
		repository: String, 
		retention: Retention, 
		schedule: CronExpression
	)
}

