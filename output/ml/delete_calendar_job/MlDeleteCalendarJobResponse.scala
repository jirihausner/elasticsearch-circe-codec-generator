package com.converted.elasticsearch.ml.delete_calendar_job

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, Ids }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		calendar_id: Id, 
		description: String, 
		job_ids: Ids
	)
}

