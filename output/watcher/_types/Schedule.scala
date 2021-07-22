package com.converted.elasticsearch.watcher._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Time.{ DateString, Time }

@JsonCodec sealed trait Schedule

@JsonCodec sealed trait ScheduleBase

@JsonCodec case class CronExpression extends ScheduleBase

@JsonCodec case class DailySchedule(
	at: Seq[String] | TimeOfDay
)

object Day extends Enumeration {
	type Day = Value

	val sunday = Value(0, "sunday")
	val monday = Value(1, "monday")
	val tuesday = Value(2, "tuesday")
	val wednesday = Value(3, "wednesday")
	val thursday = Value(4, "thursday")
	val friday = Value(5, "friday")
	val saturday = Value(6, "saturday")
}

implicit val dayDecoder: Decoder[Day.Value] = Decoder.decodeEnumeration(Day)
implicit val dayEncoder: Encoder[Day.Value] = Decoder.encodeEnumeration(Day)

@JsonCodec case class HourlySchedule(
	minute: Seq[integer]
)

@JsonCodec case class Interval(
	factor: long, 
	unit: IntervalUnit
) extends ScheduleBase

object IntervalUnit extends Enumeration {
	type IntervalUnit = Value

	val s = Value(0, "s")
	val m = Value(1, "m")
	val h = Value(2, "h")
	val d = Value(3, "d")
	val w = Value(4, "w")
}

implicit val intervalUnitDecoder: Decoder[IntervalUnit.Value] = Decoder.decodeEnumeration(IntervalUnit)
implicit val intervalUnitEncoder: Encoder[IntervalUnit.Value] = Decoder.encodeEnumeration(IntervalUnit)

object Month extends Enumeration {
	type Month = Value

	val january = Value(0, "january")
	val february = Value(1, "february")
	val march = Value(2, "march")
	val april = Value(3, "april")
	val may = Value(4, "may")
	val june = Value(5, "june")
	val july = Value(6, "july")
	val august = Value(7, "august")
	val september = Value(8, "september")
	val october = Value(9, "october")
	val november = Value(10, "november")
	val december = Value(11, "december")
}

implicit val monthDecoder: Decoder[Month.Value] = Decoder.decodeEnumeration(Month)
implicit val monthEncoder: Encoder[Month.Value] = Decoder.encodeEnumeration(Month)

@JsonCodec case class ScheduleContainer(
	cron: CronExpression, 
	daily: DailySchedule, 
	hourly: HourlySchedule, 
	interval: Time, 
	monthly: Seq[TimeOfMonth], 
	weekly: Seq[TimeOfWeek], 
	yearly: Seq[TimeOfYear]
)

@JsonCodec case class ScheduleTriggerEvent(
	scheduled_time: DateString | String, 
	triggered_time: DateString | String
)

@JsonCodec case class TimeOfDay(
	hour: Seq[integer], 
	minute: Seq[integer]
)

@JsonCodec case class TimeOfMonth(
	at: Seq[String], 
	on: Seq[integer]
)

@JsonCodec case class TimeOfWeek(
	at: Seq[String], 
	on: Seq[Day]
)

@JsonCodec case class TimeOfYear(
	at: Seq[String], 
	int: Seq[Month], 
	on: Seq[integer]
)
