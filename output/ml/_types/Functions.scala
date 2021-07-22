package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._


object CountFunction extends Enumeration {
	type CountFunction = Value

	val count = Value(0, "Count")
	val highCount = Value(1, "HighCount")
	val lowCount = Value(2, "LowCount")
}

implicit val countFunctionDecoder: Decoder[CountFunction.Value] = Decoder.decodeEnumeration(CountFunction)
implicit val countFunctionEncoder: Encoder[CountFunction.Value] = Decoder.encodeEnumeration(CountFunction)

object DistinctCountFunction extends Enumeration {
	type DistinctCountFunction = Value

	val distinctCount = Value(0, "DistinctCount")
	val lowDistinctCount = Value(1, "LowDistinctCount")
	val highDistinctCount = Value(2, "HighDistinctCount")
}

implicit val distinctCountFunctionDecoder: Decoder[DistinctCountFunction.Value] = Decoder.decodeEnumeration(DistinctCountFunction)
implicit val distinctCountFunctionEncoder: Encoder[DistinctCountFunction.Value] = Decoder.encodeEnumeration(DistinctCountFunction)

object GeographicFunction extends Enumeration {
	type GeographicFunction = Value

	val latLong = Value(0, "LatLong")
}

implicit val geographicFunctionDecoder: Decoder[GeographicFunction.Value] = Decoder.decodeEnumeration(GeographicFunction)
implicit val geographicFunctionEncoder: Encoder[GeographicFunction.Value] = Decoder.encodeEnumeration(GeographicFunction)

object InfoContentFunction extends Enumeration {
	type InfoContentFunction = Value

	val infoContent = Value(0, "InfoContent")
	val highInfoContent = Value(1, "HighInfoContent")
	val lowInfoContent = Value(2, "LowInfoContent")
}

implicit val infoContentFunctionDecoder: Decoder[InfoContentFunction.Value] = Decoder.decodeEnumeration(InfoContentFunction)
implicit val infoContentFunctionEncoder: Encoder[InfoContentFunction.Value] = Decoder.encodeEnumeration(InfoContentFunction)

object MetricFunction extends Enumeration {
	type MetricFunction = Value

	val min = Value(0, "Min")
	val max = Value(1, "Max")
	val median = Value(2, "Median")
	val highMedian = Value(3, "HighMedian")
	val lowMedian = Value(4, "LowMedian")
	val mean = Value(5, "Mean")
	val highMean = Value(6, "HighMean")
	val lowMean = Value(7, "LowMean")
	val metric = Value(8, "Metric")
	val varp = Value(9, "Varp")
	val highVarp = Value(10, "HighVarp")
	val lowVarp = Value(11, "LowVarp")
}

implicit val metricFunctionDecoder: Decoder[MetricFunction.Value] = Decoder.decodeEnumeration(MetricFunction)
implicit val metricFunctionEncoder: Encoder[MetricFunction.Value] = Decoder.encodeEnumeration(MetricFunction)

object NonNullSumFunction extends Enumeration {
	type NonNullSumFunction = Value

	val nonNullSum = Value(0, "NonNullSum")
	val highNonNullSum = Value(1, "HighNonNullSum")
	val lowNonNullSum = Value(2, "LowNonNullSum")
}

implicit val nonNullSumFunctionDecoder: Decoder[NonNullSumFunction.Value] = Decoder.decodeEnumeration(NonNullSumFunction)
implicit val nonNullSumFunctionEncoder: Encoder[NonNullSumFunction.Value] = Decoder.encodeEnumeration(NonNullSumFunction)

object NonZeroCountFunction extends Enumeration {
	type NonZeroCountFunction = Value

	val nonZeroCount = Value(0, "NonZeroCount")
	val lowNonZeroCount = Value(1, "LowNonZeroCount")
	val highNonZeroCount = Value(2, "HighNonZeroCount")
}

implicit val nonZeroCountFunctionDecoder: Decoder[NonZeroCountFunction.Value] = Decoder.decodeEnumeration(NonZeroCountFunction)
implicit val nonZeroCountFunctionEncoder: Encoder[NonZeroCountFunction.Value] = Decoder.encodeEnumeration(NonZeroCountFunction)

object RareFunction extends Enumeration {
	type RareFunction = Value

	val rare = Value(0, "Rare")
	val freqRare = Value(1, "FreqRare")
}

implicit val rareFunctionDecoder: Decoder[RareFunction.Value] = Decoder.decodeEnumeration(RareFunction)
implicit val rareFunctionEncoder: Encoder[RareFunction.Value] = Decoder.encodeEnumeration(RareFunction)

object SumFunction extends Enumeration {
	type SumFunction = Value

	val sum = Value(0, "Sum")
	val highSum = Value(1, "HighSum")
	val lowSum = Value(2, "LowSum")
}

implicit val sumFunctionDecoder: Decoder[SumFunction.Value] = Decoder.decodeEnumeration(SumFunction)
implicit val sumFunctionEncoder: Encoder[SumFunction.Value] = Decoder.encodeEnumeration(SumFunction)
