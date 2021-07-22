package com.converted.elasticsearch._types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.Numeric.{ integer, double }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.aggregations.{ AdjacencyMatrixAggregation, AutoDateHistogramAggregation, ChildrenAggregation, CompositeAggregation, DateHistogramAggregation, DateRangeAggregation, DiversifiedSamplerAggregation, FiltersAggregation, GeoDistanceAggregation, GeoHashGridAggregation, GeoTileGridAggregation, GlobalAggregation, HistogramAggregation, IpRangeAggregation, MissingAggregation, MultiTermsAggregation, NestedAggregation, ParentAggregation, RangeAggregation, RareTermsAggregation, ReverseNestedAggregation, SamplerAggregation, SignificantTermsAggregation, SignificantTextAggregation, TermsAggregation, VariableWidthHistogramAggregation }
import com.converted.elasticsearch._types.aggregations.{ MatrixStatsAggregation }
import com.converted.elasticsearch._types.aggregations.{ AverageAggregation, BoxplotAggregation, CardinalityAggregation, ExtendedStatsAggregation, GeoBoundsAggregation, GeoCentroidAggregation, GeoLineAggregation, MaxAggregation, MedianAbsoluteDeviationAggregation, MinAggregation, PercentileRanksAggregation, PercentilesAggregation, RateAggregation, ScriptedMetricAggregation, StatsAggregation, StringStatsAggregation, SumAggregation, TopHitsAggregation, TTestAggregation, TopMetricsAggregation, ValueCountAggregation, WeightedAverageAggregation }
import com.converted.elasticsearch._types.aggregations.{ AverageBucketAggregation, BucketScriptAggregation, BucketSelectorAggregation, BucketSortAggregation, CumulativeCardinalityAggregation, CumulativeSumAggregation, DerivativeAggregation, ExtendedStatsBucketAggregation, InferenceAggregation, MaxBucketAggregation, MinBucketAggregation, MovingAverageAggregation, MovingPercentilesAggregation, MovingFunctionAggregation, NormalizeAggregation, PercentilesBucketAggregation, SerialDifferencingAggregation, StatsBucketAggregation, SumBucketAggregation }

@JsonCodec case class AggregationContainer(
	aggs: Dictionary(String, AggregationContainer), 
	meta: Dictionary(String, UserDefinedValue), 
	adjacency_matrix: AdjacencyMatrixAggregation, 
	aggregations: Dictionary(String, AggregationContainer), 
	auto_date_histogram: AutoDateHistogramAggregation, 
	avg: AverageAggregation, 
	avg_bucket: AverageBucketAggregation, 
	boxplot: BoxplotAggregation, 
	bucket_script: BucketScriptAggregation, 
	bucket_selector: BucketSelectorAggregation, 
	bucket_sort: BucketSortAggregation, 
	cardinality: CardinalityAggregation, 
	children: ChildrenAggregation, 
	composite: CompositeAggregation, 
	cumulative_cardinality: CumulativeCardinalityAggregation, 
	cumulative_sum: CumulativeSumAggregation, 
	date_histogram: DateHistogramAggregation, 
	date_range: DateRangeAggregation, 
	derivative: DerivativeAggregation, 
	diversified_sampler: DiversifiedSamplerAggregation, 
	extended_stats: ExtendedStatsAggregation, 
	extended_stats_bucket: ExtendedStatsBucketAggregation, 
	filter: QueryContainer, 
	filters: FiltersAggregation, 
	geo_bounds: GeoBoundsAggregation, 
	geo_centroid: GeoCentroidAggregation, 
	geo_distance: GeoDistanceAggregation, 
	geohash_grid: GeoHashGridAggregation, 
	geo_line: GeoLineAggregation, 
	geotile_grid: GeoTileGridAggregation, 
	global: GlobalAggregation, 
	histogram: HistogramAggregation, 
	ip_range: IpRangeAggregation, 
	inference: InferenceAggregation, 
	line: GeoLineAggregation, 
	matrix_stats: MatrixStatsAggregation, 
	max: MaxAggregation, 
	max_bucket: MaxBucketAggregation, 
	median_absolute_deviation: MedianAbsoluteDeviationAggregation, 
	min: MinAggregation, 
	min_bucket: MinBucketAggregation, 
	missing: MissingAggregation, 
	moving_avg: MovingAverageAggregation, 
	moving_percentiles: MovingPercentilesAggregation, 
	moving_fn: MovingFunctionAggregation, 
	multi_terms: MultiTermsAggregation, 
	nested: NestedAggregation, 
	normalize: NormalizeAggregation, 
	parent: ParentAggregation, 
	percentile_ranks: PercentileRanksAggregation, 
	percentiles: PercentilesAggregation, 
	percentiles_bucket: PercentilesBucketAggregation, 
	range: RangeAggregation, 
	rare_terms: RareTermsAggregation, 
	rate: RateAggregation, 
	reverse_nested: ReverseNestedAggregation, 
	sampler: SamplerAggregation, 
	scripted_metric: ScriptedMetricAggregation, 
	serial_diff: SerialDifferencingAggregation, 
	significant_terms: SignificantTermsAggregation, 
	significant_text: SignificantTextAggregation, 
	stats: StatsAggregation, 
	stats_bucket: StatsBucketAggregation, 
	string_stats: StringStatsAggregation, 
	sum: SumAggregation, 
	sum_bucket: SumBucketAggregation, 
	terms: TermsAggregation, 
	top_hits: TopHitsAggregation, 
	t_test: TTestAggregation, 
	top_metrics: TopMetricsAggregation, 
	value_count: ValueCountAggregation, 
	weighted_avg: WeightedAverageAggregation, 
	variable_width_histogram: VariableWidthHistogramAggregation
)

type Missing = String | integer | double | Boolean
