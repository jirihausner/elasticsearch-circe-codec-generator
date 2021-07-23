/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.circecodecs.types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.global.search.types.hits.{ HitsMetadata }
import org.elasticsearch.circecodecs.spec_utils.behaviors.{ AdditionalProperties }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ AggregateName }
import org.elasticsearch.circecodecs.types.Geo.{ LatLon }
import org.elasticsearch.circecodecs.types.Numeric.{ double, integer, long }
import org.elasticsearch.circecodecs.types.query_dsl.geo.{ GeoCoordinate, GeoLocation }
import org.elasticsearch.circecodecs.types.Time.{ DateMathTime }
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
	buckets: Seq[TBucket]
) extends AggregateBase

@JsonCodec case class ValueAggregate(
	value: double, 
	value_as_string: String
) extends AggregateBase

@JsonCodec case class SingleBucketAggregate(
	doc_count: double
) extends AggregateBase, AdditionalProperties[AggregateName, Aggregate]

@JsonCodec case class KeyedValueAggregate(
	keys: Seq[String]
) extends ValueAggregate

@JsonCodec case class AutoDateHistogramAggregate(
	interval: DateMathTime
) extends MultiBucketAggregate[KeyedBucket[long]]

@JsonCodec case class FiltersAggregate(
	buckets: Seq[FiltersBucketItem] | Dictionary[String, FiltersBucketItem]
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
	sort_values: Seq[double]
)

@JsonCodec case class LineStringGeoShape(
	coordinates: Seq[GeoCoordinate]
)

@JsonCodec case class PercentileItem(
	percentile: double, 
	value: double
)

@JsonCodec case class PercentilesAggregate(
	items: Seq[PercentileItem]
) extends AggregateBase

@JsonCodec case class TDigestPercentilesAggregate(
	values: Dictionary[String, double]
) extends AggregateBase

@JsonCodec case class HdrPercentileItem(
	key: double, 
	value: double
)

@JsonCodec case class HdrPercentilesAggregate(
	values: Seq[HdrPercentileItem]
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
	top: Seq[TopMetrics]
) extends AggregateBase

@JsonCodec case class TopMetrics(
	sort: Seq[long | double | String], 
	metrics: Dictionary[String, long | double | String]
)
