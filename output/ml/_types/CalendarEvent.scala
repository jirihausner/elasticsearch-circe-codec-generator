package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Time.{ EpochMillis }

@JsonCodec case class CalendarEvent(
	calendar_id: Id, 
	event_id: Id, 
	description: String, 
	end_time: EpochMillis, 
	start_time: EpochMillis
)

