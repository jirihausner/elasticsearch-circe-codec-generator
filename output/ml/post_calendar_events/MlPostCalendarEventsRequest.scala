package com.converted.elasticsearch.ml.post_calendar_events

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch.ml.post_calendar_events.{ CalendarEvent }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		calendar_id: Id
	)
	@JsonCodec case class Body(
		events: Array[CalendarEvent]
	)
}

