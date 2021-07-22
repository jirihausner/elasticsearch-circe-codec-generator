package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.{ Field }
import com.converted.elasticsearch._types.{ integer, long }

@JsonCodec case class DateMathTimeParsed(
	factor: integer, 
	interval: DateMathTimeUnit
)

@JsonCodec case class DateField(
	field: Field, 
	format: String, 
	include_unmapped: Boolean
)
type DateString = String
type Timestamp = String
type TimeSpan = String
type EpochMillis = String | long
type DateMath = String
type DateMathExpression = String
type DateMathTime = String

object DateMathOperation extends Enumeration {
	type DateMathOperation = Value

	val + = Value(0, "+")
	val - = Value(1, "-")
}

implicit val dateMathOperationDecoder: Decoder[DateMathOperation.Value] = Decoder.decodeEnumeration(DateMathOperation)
implicit val dateMathOperationEncoder: Encoder[DateMathOperation.Value] = Decoder.encodeEnumeration(DateMathOperation)

object DateMathTimeUnit extends Enumeration {
	type DateMathTimeUnit = Value

	val s = Value(0, "s")
	val m = Value(1, "m")
	val h = Value(2, "h")
	val d = Value(3, "d")
	val w = Value(4, "w")
	val m = Value(5, "M")
	val y = Value(6, "y")
}

implicit val dateMathTimeUnitDecoder: Decoder[DateMathTimeUnit.Value] = Decoder.decodeEnumeration(DateMathTimeUnit)
implicit val dateMathTimeUnitEncoder: Encoder[DateMathTimeUnit.Value] = Decoder.encodeEnumeration(DateMathTimeUnit)
type Time = String | integer

object TimeUnit extends Enumeration {
	type TimeUnit = Value

	val nanos = Value(0, "nanos")
	val micros = Value(1, "micros")
	val ms = Value(2, "ms")
	val s = Value(3, "s")
	val m = Value(4, "m")
	val h = Value(5, "h")
	val d = Value(6, "d")
}

implicit val timeUnitDecoder: Decoder[TimeUnit.Value] = Decoder.decodeEnumeration(TimeUnit)
implicit val timeUnitEncoder: Encoder[TimeUnit.Value] = Decoder.encodeEnumeration(TimeUnit)
