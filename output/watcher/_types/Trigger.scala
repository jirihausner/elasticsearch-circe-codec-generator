package com.converted.elasticsearch.watcher._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Time.{ DateString }
import com.converted.elasticsearch.watcher._types.{ ScheduleContainer, ScheduleTriggerEvent }

@JsonCodec case class TriggerContainer(
	schedule: ScheduleContainer
)


@JsonCodec sealed trait TriggerEvent


@JsonCodec case class TriggerEventContainer(
	schedule: ScheduleTriggerEvent
)


@JsonCodec case class TriggerEventResult(
	manual: TriggerEventContainer, 
	triggered_time: DateString, 
	`type`: String
)

