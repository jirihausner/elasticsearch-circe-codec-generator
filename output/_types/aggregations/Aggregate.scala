package com.converted.elasticsearch._types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.hits.{ HitsMetadata }
import com.converted.elasticsearch._spec_utils.behaviors.{ AdditionalProperties }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ AggregateName }
import com.converted.elasticsearch._types.Geo.{ LatLon }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.query_dsl.geo.{ GeoCoordinate, GeoLocation }
import com.converted.elasticsearch._types.Time.{ DateMathTime }
type Bucket = CompositeBucket | DateHistogramBucket | FiltersBucketItem | IpRangeBucket | RangeBucket | RareTermsBucket[UserDefinedValue] | SignificantTermsBucket[UserDefinedValue] | KeyedBucket[UserDefinedValue]

@JsonCodec case class CompositeBucket extends AdditionalProperties[AggregateName, Aggregate]

@JsonCodec case class DateHistogramBucket extends AdditionalProperties[AggregateName, Aggregate]

@JsonCodec case class FiltersBucketItem(
	doc_count: long
) extends AdditionalProperties[AggregateName, Aggregate]

@JsonCodec case class IpRangeBucket extends AdditionalProperties[AggregateName, Aggregate]

@JsonCodec case class RangeBucket extends AdditionalProperties[AggregateName, Aggregate]

@JsonCodec case class RareTermsBucket[TKey] extends AdditionalProperties[AggregateName, Aggregate]

@JsonCodec case class SignificantTermsBucket[TKey] extends AdditionalProperties[AggregateName, Aggregate]

@JsonCodec case class KeyedBucket[TKey](
	doc_count: long, 
	key: TKey, 
	key_as_string: String
) extends AdditionalProperties[AggregateName, Aggregate]
type Aggregate = SingleBucketAggregate | AutoDateHistogramAggregate | FiltersAggregate | SignificantTermsAggregate[UserDefinedValue] | TermsAggregate[UserDefinedValue] | BucketAggregate | CompositeBucketAggregate | MultiBucketAggregate[Bucket] | MatrixStatsAggregate | KeyedValueAggregate | MetricAggregate
type MetricAggregate = ValueAggregate | BoxPlotAggregate | GeoBoundsAggregate | GeoCentroidAggregate | GeoLineAggregate | PercentilesAggregate | ScriptedMetricAggregate | StatsAggregate | StringStatsAggregate | TopHitsAggregate | TopMetricsAggregate | ExtendedStatsAggregate | TDigestPercentilesAggregate | HdrPercentilesAggregate

@JsonCodec case class AggregateBase(
	meta: Dictionary[String, UserDefinedValue]
)

@JsonCodec case class MultiBucketAggregate[TBucket](
	buckets: Array[TBucket]
) extends AggregateBase

@JsonCodec case class ValueAggregate(
	value: double, 
	value_as_string: String
) extends AggregateBase

@JsonCodec case class SingleBucketAggregate(
	doc_count: double
) extends AggregateBase, AdditionalProperties[AggregateName, Aggregate]

@JsonCodec case class KeyedValueAggregate(
	keys: Array[String]
) extends ValueAggregate

@JsonCodec case class AutoDateHistogramAggregate(
	interval: DateMathTime
) extends MultiBucketAggregate[KeyedBucket[long]]

@JsonCodec case class FiltersAggregate(
	buckets: Array[FiltersBucketItem] | Dictionary[String, FiltersBucketItem]
) extends AggregateBase

@JsonCodec case class SignificantTermsAggregate[TKey](
	bg_count: long, 
	doc_count: long
) extends MultiBucketAggregate[TKey]

@JsonCodec case class TermsAggregate[TKey](
	doc_count_error_upper_bound: long, 
	sum_other_doc_count: long
) extends MultiBucketAggregate[TKey]

@JsonCodec case class BucketAggregate(
	after_key: Dictionary[String, UserDefinedValue], 
	bg_count: long, 
	doc_count: long, 
	doc_count_error_upper_bound: long, 
	sum_other_doc_count: long, 
	interval: DateMathTime, 
	items: Bucket
) extends AggregateBase

@JsonCodec case class CompositeBucketAggregate(
	after_key: Dictionary[String, UserDefinedValue]
) extends MultiBucketAggregate[Dictionary[String, UserDefinedValue]]

@JsonCodec case class MatrixStatsAggregate(
	correlation: Dictionary[String, double], 
	covariance: Dictionary[String, double], 
	count: integer, 
	kurtosis: double, 
	mean: double, 
	skewness: double, 
	variance: double, 
	name: String
) extends AggregateBase

@JsonCodec case class BoxPlotAggregate(
	min: double, 
	max: double, 
	q1: double, 
	q2: double, 
	q3: double
) extends AggregateBase

@JsonCodec case class StatsAggregate(
	count: double, 
	sum: double, 
	avg: double, 
	max: double, 
	min: double
) extends AggregateBase

@JsonCodec case class StandardDeviationBounds(
	lower: double, 
	upper: double, 
	lower_population: double, 
	upper_population: double, 
	lower_sampling: double, 
	upper_sampling: double
)

@JsonCodec case class ExtendedStatsAggregate(
	std_deviation_bounds: StandardDeviationBounds, 
	sum_of_squares: double, 
	variance: double, 
	variance_population: double, 
	variance_sampling: double, 
	std_deviation: double, 
	std_deviation_population: double, 
	std_deviation_sampling: double
) extends StatsAggregate

@JsonCodec case class GeoBounds(
	bottom_right: LatLon, 
	top_left: LatLon
)

@JsonCodec case class GeoBoundsAggregate(
	bounds: GeoBounds
) extends AggregateBase

@JsonCodec case class GeoCentroidAggregate(
	count: long, 
	location: GeoLocation
) extends AggregateBase

@JsonCodec case class GeoLineAggregate(
	`type`: String, 
	geometry: LineStringGeoShape, 
	properties: GeoLineProperties
) extends AggregateBase

@JsonCodec case class GeoLineProperties(
	complete: Boolean, 
	sort_values: Array[double]
)

@JsonCodec case class LineStringGeoShape(
	coordinates: Array[GeoCoordinate]
)

@JsonCodec case class PercentileItem(
	percentile: double, 
	value: double
)

@JsonCodec case class PercentilesAggregate(
	items: Array[PercentileItem]
) extends AggregateBase

@JsonCodec case class TDigestPercentilesAggregate(
	values: Dictionary[String, double]
) extends AggregateBase

@JsonCodec case class HdrPercentileItem(
	key: double, 
	value: double
)

@JsonCodec case class HdrPercentilesAggregate(
	values: Array[HdrPercentileItem]
) extends AggregateBase

@JsonCodec case class ScriptedMetricAggregate(
	value: UserDefinedValue
) extends AggregateBase

@JsonCodec case class StringStatsAggregate(
	count: long, 
	min_length: integer, 
	max_length: integer, 
	avg_length: double, 
	entropy: double, 
	distribution: Dictionary[String, double]
) extends AggregateBase

@JsonCodec case class TopHitsAggregate(
	hits: HitsMetadata[Dictionary[String, UserDefinedValue]]
) extends AggregateBase

@JsonCodec case class TopMetricsAggregate(
	top: Array[TopMetrics]
) extends AggregateBase

@JsonCodec case class TopMetrics(
	sort: Array[long | double | String], 
	metrics: Dictionary[String, long | double | String]
)
