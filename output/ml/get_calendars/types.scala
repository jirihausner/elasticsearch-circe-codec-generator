package com.converted.elasticsearch.ml.get_calendars

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Calendar(
	calendar_id: Id, 
	description: String, 
	job_ids: Array[Id]
)
