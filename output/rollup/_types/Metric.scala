package com.converted.elasticsearch.rollup._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }

object Metric extends Enumeration {
	type Metric = Value

	val min = Value(0, "min")
	val max = Value(1, "max")
	val sum = Value(2, "sum")
	val avg = Value(3, "avg")
	val value_count = Value(4, "value_count")
}

implicit val metricDecoder: Decoder[Metric.Value] = Decoder.decodeEnumeration(Metric)
implicit val metricEncoder: Encoder[Metric.Value] = Decoder.encodeEnumeration(Metric)

@JsonCodec case class FieldMetric(
	field: Field, 
	metrics: Array(Metric)
)
