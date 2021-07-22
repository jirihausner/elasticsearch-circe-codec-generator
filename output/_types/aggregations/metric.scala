package com.converted.elasticsearch._types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.highlighting.{ Highlight }
import com.converted.elasticsearch._global.search._types.sort.{ SortOrder, Sort }
import com.converted.elasticsearch._global.search._types.SourceFilter.{ SourceFilter }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Field, Fields }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.query_dsl.geo.{ GeoLocation }
import com.converted.elasticsearch._types.Scripting.{ Script, ScriptField }
import com.converted.elasticsearch._types.aggregations.{ Aggregation }
import com.converted.elasticsearch._types.aggregations.{ Missing }
import com.converted.elasticsearch._types.aggregations.{ DateInterval }

@JsonCodec case class MetricAggregationBase(
	field: Field, 
	missing: Missing, 
	script: Script
)

@JsonCodec case class FormatMetricAggregationBase(
	format: String
) extends MetricAggregationBase

@JsonCodec case class FormattableMetricAggregation(
	format: String
) extends MetricAggregationBase

@JsonCodec case class AverageAggregation extends FormatMetricAggregationBase

@JsonCodec case class BoxplotAggregation(
	compression: double
) extends MetricAggregationBase

@JsonCodec case class CardinalityAggregation(
	precision_threshold: integer, 
	rehash: Boolean
) extends MetricAggregationBase

@JsonCodec case class ExtendedStatsAggregation(
	sigma: double
) extends FormatMetricAggregationBase

@JsonCodec case class GeoBoundsAggregation(
	wrap_longitude: Boolean
) extends MetricAggregationBase

@JsonCodec case class GeoCentroidAggregation(
	count: long, 
	location: GeoLocation
) extends MetricAggregationBase

@JsonCodec case class GeoLineAggregation(
	point: GeoLinePoint, 
	sort: GeoLineSort, 
	include_sort: Boolean, 
	sort_order: SortOrder, 
	size: integer
)

@JsonCodec case class GeoLineSort(
	field: Field
)

@JsonCodec case class GeoLinePoint(
	field: Field
)

@JsonCodec case class MaxAggregation extends FormatMetricAggregationBase

@JsonCodec case class MedianAbsoluteDeviationAggregation(
	compression: double
) extends FormatMetricAggregationBase

@JsonCodec case class MinAggregation extends FormatMetricAggregationBase

@JsonCodec case class PercentileRanksAggregation(
	keyed: Boolean, 
	values: Array(double), 
	hdr: HdrMethod, 
	tdigest: TDigest
) extends FormatMetricAggregationBase

@JsonCodec case class PercentilesAggregation(
	keyed: Boolean, 
	percents: Array(double), 
	hdr: HdrMethod, 
	tdigest: TDigest
) extends FormatMetricAggregationBase

@JsonCodec case class HdrMethod(
	number_of_significant_value_digits: integer
)

@JsonCodec case class TDigest(
	compression: integer
)

@JsonCodec case class RateAggregation(
	unit: DateInterval, 
	mode: RateMode
) extends FormatMetricAggregationBase

object RateMode extends Enumeration {
	type RateMode = Value

	val sum = Value("sum")
	val value_count = Value("value_count")
}

implicit val rateModeDecoder: Decoder[RateMode.Value] = Decoder.decodeEnumeration(RateMode)
implicit val rateModeEncoder: Encoder[RateMode.Value] = Decoder.encodeEnumeration(RateMode)

@JsonCodec case class ScriptedMetricAggregation(
	combine_script: Script, 
	init_script: Script, 
	map_script: Script, 
	params: Dictionary(String, UserDefinedValue), 
	reduce_script: Script
) extends MetricAggregationBase

@JsonCodec case class StatsAggregation extends FormatMetricAggregationBase

@JsonCodec case class StringStatsAggregation(
	show_distribution: Boolean
) extends MetricAggregationBase

@JsonCodec case class SumAggregation extends FormatMetricAggregationBase

@JsonCodec case class TTestAggregation(
	a: TestPopulation, 
	b: TestPopulation, 
	`type`: TTestType
) extends Aggregation

@JsonCodec case class TestPopulation(
	field: Field, 
	script: Script, 
	filter: QueryContainer
)

object TTestType extends Enumeration {
	type TTestType = Value

	val paired = Value("paired")
	val homoscedastic = Value("homoscedastic")
	val heteroscedastic = Value("heteroscedastic")
}

implicit val tTestTypeDecoder: Decoder[TTestType.Value] = Decoder.decodeEnumeration(TTestType)
implicit val tTestTypeEncoder: Encoder[TTestType.Value] = Decoder.encodeEnumeration(TTestType)

@JsonCodec case class TopHitsAggregation(
	docvalue_fields: Fields, 
	explain: Boolean, 
	from: integer, 
	highlight: Highlight, 
	script_fields: Dictionary(String, ScriptField), 
	size: integer, 
	sort: Sort, 
	_source: Boolean | SourceFilter | Fields, 
	stored_fields: Fields, 
	track_scores: Boolean, 
	version: Boolean, 
	seq_no_primary_term: Boolean
) extends MetricAggregationBase

@JsonCodec case class TopMetricsAggregation(
	metrics: TopMetricsValue | Array(TopMetricsValue), 
	size: integer, 
	sort: Sort
) extends MetricAggregationBase

@JsonCodec case class TopMetricsValue(
	field: Field
)

@JsonCodec case class ValueCountAggregation extends FormattableMetricAggregation

object ValueType extends Enumeration {
	type ValueType = Value

	val string = Value(0, "string")
	val long = Value(1, "long")
	val double = Value(2, "double")
	val number = Value(3, "number")
	val date = Value(4, "date")
	val date_nanos = Value(5, "date_nanos")
	val ip = Value(6, "ip")
	val numeric = Value(7, "numeric")
	val geo_point = Value(8, "geo_point")
	val boolean = Value(9, "boolean")
}

implicit val valueTypeDecoder: Decoder[ValueType.Value] = Decoder.decodeEnumeration(ValueType)
implicit val valueTypeEncoder: Encoder[ValueType.Value] = Decoder.encodeEnumeration(ValueType)

@JsonCodec case class WeightedAverageAggregation(
	format: String, 
	value: WeightedAverageValue, 
	value_type: ValueType, 
	weight: WeightedAverageValue
) extends Aggregation

@JsonCodec case class WeightedAverageValue(
	field: Field, 
	missing: double, 
	script: Script
)
