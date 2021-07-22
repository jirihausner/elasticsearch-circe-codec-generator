package com.converted.elasticsearch.rollup._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field, Fields }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Groupings(
	date_histogram: DateHistogramGrouping, 
	histogram: HistogramGrouping, 
	terms: TermsGrouping
)


@JsonCodec case class DateHistogramGrouping(
	delay: Time, 
	field: Field, 
	format: String, 
	interval: Time, 
	calendar_interval: Time, 
	fixed_interval: Time, 
	time_zone: String
)


@JsonCodec case class TermsGrouping(
	fields: Fields
)


@JsonCodec case class HistogramGrouping(
	fields: Fields, 
	interval: Long
)

