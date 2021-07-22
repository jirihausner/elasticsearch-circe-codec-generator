package com.converted.elasticsearch.ml.post_calendar_events

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.ml.post_calendar_events.{ CalendarEvent }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		events: Array[CalendarEvent]
	)
}

