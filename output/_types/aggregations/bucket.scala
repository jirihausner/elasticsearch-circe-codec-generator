package com.converted.elasticsearch._types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.sort.{ SortOrder }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Field, RelationName, Fields }
import com.converted.elasticsearch._types.Geo.{ GeoDistanceType, DistanceUnit, GeoHashPrecision, GeoTilePrecision }
import com.converted.elasticsearch._types.Numeric.{ integer, float, long, double }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.query_dsl.geo.{ GeoLocation, BoundingBox }
import com.converted.elasticsearch._types.Scripting.{ Script }
import com.converted.elasticsearch._types.Time.{ DateString, Time, DateMath }
import com.converted.elasticsearch._types.aggregations.{ GeoBounds }
import com.converted.elasticsearch._types.aggregations.{ Aggregation }
import com.converted.elasticsearch._types.aggregations.{ AggregationContainer, Missing }

@JsonCodec case class BucketAggregationBase(
	aggregations: Dictionary[String, AggregationContainer]
) extends Aggregation

@JsonCodec case class AdjacencyMatrixAggregation(
	filters: Dictionary[String, QueryContainer]
) extends BucketAggregationBase

@JsonCodec case class AutoDateHistogramAggregation(
	buckets: integer, 
	field: Field, 
	format: String, 
	minimum_interval: MinimumInterval, 
	missing: DateString, 
	offset: String, 
	params: Dictionary[String, UserDefinedValue], 
	script: Script, 
	time_zone: String
) extends BucketAggregationBase

object MinimumInterval extends Enumeration {
	type MinimumInterval = Value

	val second = Value(0, "second")
	val minute = Value(1, "minute")
	val hour = Value(2, "hour")
	val day = Value(3, "day")
	val month = Value(4, "month")
	val year = Value(5, "year")
}

implicit val minimumIntervalDecoder: Decoder[MinimumInterval.Value] = Decoder.decodeEnumeration(MinimumInterval)
implicit val minimumIntervalEncoder: Encoder[MinimumInterval.Value] = Decoder.encodeEnumeration(MinimumInterval)

@JsonCodec case class ChildrenAggregation(
	`type`: RelationName
) extends BucketAggregationBase

@JsonCodec case class CompositeAggregation(
	after: Dictionary[String, String | float | null], 
	size: integer, 
	sources: Seq[Dictionary[String, CompositeAggregationSource]]
) extends BucketAggregationBase

@JsonCodec case class CompositeAggregationSource(
	terms: TermsAggregation, 
	histogram: HistogramAggregation, 
	date_histogram: DateHistogramAggregation, 
	geotile_grid: GeoTileGridAggregation
)

@JsonCodec case class DateHistogramAggregation(
	calendar_interval: DateInterval | Time, 
	extended_bounds: ExtendedBounds[DateMath | long], 
	hard_bounds: ExtendedBounds[DateMath | long], 
	field: Field, 
	fixed_interval: DateInterval | Time, 
	format: String, 
	interval: DateInterval | Time, 
	min_doc_count: integer, 
	missing: DateString, 
	offset: Time, 
	order: HistogramOrder, 
	params: Dictionary[String, UserDefinedValue], 
	script: Script, 
	time_zone: String
) extends BucketAggregationBase

object DateInterval extends Enumeration {
	type DateInterval = Value

	val second = Value(0, "second")
	val minute = Value(1, "minute")
	val hour = Value(2, "hour")
	val day = Value(3, "day")
	val week = Value(4, "week")
	val month = Value(5, "month")
	val quarter = Value(6, "quarter")
	val year = Value(7, "year")
}

implicit val dateIntervalDecoder: Decoder[DateInterval.Value] = Decoder.decodeEnumeration(DateInterval)
implicit val dateIntervalEncoder: Encoder[DateInterval.Value] = Decoder.encodeEnumeration(DateInterval)

@JsonCodec case class DateRangeAggregation(
	field: Field, 
	format: String, 
	missing: Missing, 
	ranges: Seq[DateRangeExpression], 
	time_zone: String
) extends BucketAggregationBase

@JsonCodec case class DateRangeExpression(
	from: DateMath | float, 
	from_as_string: String, 
	to_as_string: String, 
	key: String, 
	to: DateMath | float, 
	doc_count: long
)

@JsonCodec case class DiversifiedSamplerAggregation(
	execution_hint: SamplerAggregationExecutionHint, 
	max_docs_per_value: integer, 
	script: Script, 
	shard_size: integer, 
	field: Field
) extends BucketAggregationBase

object SamplerAggregationExecutionHint extends Enumeration {
	type SamplerAggregationExecutionHint = Value

	val map = Value(0, "map")
	val global_ordinals = Value(1, "global_ordinals")
	val bytes_hash = Value(2, "bytes_hash")
}

implicit val samplerAggregationExecutionHintDecoder: Decoder[SamplerAggregationExecutionHint.Value] = Decoder.decodeEnumeration(SamplerAggregationExecutionHint)
implicit val samplerAggregationExecutionHintEncoder: Encoder[SamplerAggregationExecutionHint.Value] = Decoder.encodeEnumeration(SamplerAggregationExecutionHint)

@JsonCodec case class FiltersAggregation(
	filters: Dictionary[String, QueryContainer] | Seq[QueryContainer], 
	other_bucket: Boolean, 
	other_bucket_key: String
) extends BucketAggregationBase

@JsonCodec case class GeoDistanceAggregation(
	distance_type: GeoDistanceType, 
	field: Field, 
	origin: GeoLocation | String, 
	ranges: Seq[AggregationRange], 
	unit: DistanceUnit
) extends BucketAggregationBase

@JsonCodec case class GeoHashGridAggregation(
	bounds: BoundingBox, 
	field: Field, 
	precision: GeoHashPrecision, 
	shard_size: integer, 
	size: integer
) extends BucketAggregationBase

@JsonCodec case class GeoTileGridAggregation(
	field: Field, 
	precision: GeoTilePrecision, 
	shard_size: integer, 
	size: integer, 
	bounds: GeoBounds
) extends BucketAggregationBase

@JsonCodec case class GlobalAggregation extends BucketAggregationBase

@JsonCodec case class ExtendedBounds[T](
	max: T, 
	min: T
)

@JsonCodec case class HistogramAggregation(
	extended_bounds: ExtendedBounds[double], 
	hard_bounds: ExtendedBounds[double], 
	field: Field, 
	interval: double, 
	min_doc_count: integer, 
	missing: double, 
	offset: double, 
	order: HistogramOrder, 
	script: Script, 
	format: String
) extends BucketAggregationBase

@JsonCodec case class HistogramOrder(
	_count: SortOrder, 
	_key: SortOrder
)

@JsonCodec case class IpRangeAggregation(
	field: Field, 
	ranges: Seq[IpRangeAggregationRange]
) extends BucketAggregationBase

@JsonCodec case class IpRangeAggregationRange(
	from: String, 
	mask: String, 
	to: String
)

@JsonCodec case class MissingAggregation(
	field: Field, 
	missing: Missing
) extends BucketAggregationBase

@JsonCodec case class MultiTermsAggregation(
	terms: Seq[MultiTermLookup]
) extends BucketAggregationBase

@JsonCodec case class MultiTermLookup(
	field: Field
)

@JsonCodec case class NestedAggregation(
	path: Field
) extends BucketAggregationBase

@JsonCodec case class ParentAggregation(
	`type`: RelationName
) extends BucketAggregationBase

@JsonCodec case class RangeAggregation(
	field: Field, 
	ranges: Seq[AggregationRange], 
	script: Script
) extends BucketAggregationBase

@JsonCodec case class AggregationRange(
	from: double | String, 
	key: String, 
	to: double | String
)

@JsonCodec case class RareTermsAggregation(
	exclude: String | Seq[String], 
	field: Field, 
	include: String | Seq[String] | TermsInclude, 
	max_doc_count: long, 
	missing: Missing, 
	precision: double, 
	value_type: String
) extends BucketAggregationBase

@JsonCodec case class ReverseNestedAggregation(
	path: Field
) extends BucketAggregationBase

@JsonCodec case class SamplerAggregation(
	shard_size: integer
) extends BucketAggregationBase

@JsonCodec case class ChiSquareHeuristic(
	background_is_superset: Boolean, 
	include_negatives: Boolean
)

@JsonCodec case class GoogleNormalizedDistanceHeuristic(
	background_is_superset: Boolean
)

@JsonCodec case class MutualInformationHeuristic(
	background_is_superset: Boolean, 
	include_negatives: Boolean
)

@JsonCodec sealed trait PercentageScoreHeuristic

@JsonCodec case class ScriptedHeuristic(
	script: Script
)

@JsonCodec case class SignificantTermsAggregation(
	background_filter: QueryContainer, 
	chi_square: ChiSquareHeuristic, 
	exclude: String | Seq[String], 
	execution_hint: TermsAggregationExecutionHint, 
	field: Field, 
	gnd: GoogleNormalizedDistanceHeuristic, 
	include: String | Seq[String], 
	min_doc_count: long, 
	mutual_information: MutualInformationHeuristic, 
	percentage: PercentageScoreHeuristic, 
	script_heuristic: ScriptedHeuristic, 
	shard_min_doc_count: long, 
	shard_size: integer, 
	size: integer
) extends BucketAggregationBase

@JsonCodec case class SignificantTextAggregation(
	background_filter: QueryContainer, 
	chi_square: ChiSquareHeuristic, 
	exclude: String | Seq[String], 
	execution_hint: TermsAggregationExecutionHint, 
	field: Field, 
	filter_duplicate_text: Boolean, 
	gnd: GoogleNormalizedDistanceHeuristic, 
	include: String | Seq[String], 
	min_doc_count: long, 
	mutual_information: MutualInformationHeuristic, 
	percentage: PercentageScoreHeuristic, 
	script_heuristic: ScriptedHeuristic, 
	shard_min_doc_count: long, 
	shard_size: integer, 
	size: integer, 
	source_fields: Fields
) extends BucketAggregationBase

@JsonCodec case class TermsAggregation(
	collect_mode: TermsAggregationCollectMode, 
	exclude: String | Seq[String], 
	execution_hint: TermsAggregationExecutionHint, 
	field: Field, 
	include: String | Seq[String] | TermsInclude, 
	min_doc_count: integer, 
	missing: Missing, 
	missing_bucket: Boolean, 
	value_type: String, 
	order: TermsAggregationOrder, 
	script: Script, 
	shard_size: integer, 
	show_term_doc_count_error: Boolean, 
	size: integer
) extends BucketAggregationBase
type TermsAggregationOrder = SortOrder | Dictionary[String, SortOrder] | Seq[Dictionary[String, SortOrder]]

object TermsAggregationCollectMode extends Enumeration {
	type TermsAggregationCollectMode = Value

	val depth_first = Value(0, "depth_first")
	val breadth_first = Value(1, "breadth_first")
}

implicit val termsAggregationCollectModeDecoder: Decoder[TermsAggregationCollectMode.Value] = Decoder.decodeEnumeration(TermsAggregationCollectMode)
implicit val termsAggregationCollectModeEncoder: Encoder[TermsAggregationCollectMode.Value] = Decoder.encodeEnumeration(TermsAggregationCollectMode)

object TermsAggregationExecutionHint extends Enumeration {
	type TermsAggregationExecutionHint = Value

	val map = Value(0, "map")
	val global_ordinals = Value(1, "global_ordinals")
	val global_ordinals_hash = Value(2, "global_ordinals_hash")
	val global_ordinals_low_cardinality = Value(3, "global_ordinals_low_cardinality")
}

implicit val termsAggregationExecutionHintDecoder: Decoder[TermsAggregationExecutionHint.Value] = Decoder.decodeEnumeration(TermsAggregationExecutionHint)
implicit val termsAggregationExecutionHintEncoder: Encoder[TermsAggregationExecutionHint.Value] = Decoder.encodeEnumeration(TermsAggregationExecutionHint)

@JsonCodec case class TermsInclude(
	num_partitions: long, 
	partition: long
)

@JsonCodec case class VariableWidthHistogramAggregation(
	field: Field, 
	buckets: integer, 
	shard_size: integer, 
	initial_buffer: integer
)
