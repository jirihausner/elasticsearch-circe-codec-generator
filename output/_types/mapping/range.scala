package com.converted.elasticsearch._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ double }
import com.converted.elasticsearch._types.mapping.{ DocValuesPropertyBase }

@JsonCodec case class RangePropertyBase(
	boost: double, 
	coerce: Boolean, 
	index: Boolean
) extends DocValuesPropertyBase
type RangeProperty = LongRangeProperty | IpRangeProperty | IntegerRangeProperty | FloatRangeProperty | DoubleRangeProperty | DateRangeProperty

@JsonCodec case class DateRangeProperty(
	format: String, 
	`type`: "date_range""
) extends RangePropertyBase

@JsonCodec case class DoubleRangeProperty(
	`type`: "double_range""
) extends RangePropertyBase

@JsonCodec case class FloatRangeProperty(
	`type`: "float_range""
) extends RangePropertyBase

@JsonCodec case class IntegerRangeProperty(
	`type`: "integer_range""
) extends RangePropertyBase

@JsonCodec case class IpRangeProperty(
	`type`: "ip_range""
) extends RangePropertyBase

@JsonCodec case class LongRangeProperty(
	`type`: "long_range""
) extends RangePropertyBase
