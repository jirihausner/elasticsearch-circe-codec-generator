package com.converted.elasticsearch.ml.preview_datafeed

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._ml._types.Job.{ Job }
import com.converted.elasticsearch._ml._types.Datafeed.{ Datafeed }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		datafeed_id: Id
	)
	@JsonCodec case class Body(
		job_config: Job, 
		datafeed_config: Datafeed
	)
}

