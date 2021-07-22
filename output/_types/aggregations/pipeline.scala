package com.converted.elasticsearch._types.aggregations

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.sort.{ Sort }
import com.converted.elasticsearch._types.common.{ Name, Field }
import com.converted.elasticsearch._types.Numeric.{ integer, double, float }
import com.converted.elasticsearch._types.Scripting.{ Script }
import com.converted.elasticsearch._types.aggregations.{ Aggregation }

@JsonCodec case class PipelineAggregationBase(
	buckets_path: BucketsPath, 
	format: String, 
	gap_policy: GapPolicy
) extends Aggregation

object GapPolicy extends Enumeration {
	type GapPolicy = Value

	val skip = Value(0, "skip")
	val insert_zeros = Value(1, "insert_zeros")
}

implicit val gapPolicyDecoder: Decoder[GapPolicy.Value] = Decoder.decodeEnumeration(GapPolicy)
implicit val gapPolicyEncoder: Encoder[GapPolicy.Value] = Decoder.encodeEnumeration(GapPolicy)

@JsonCodec sealed trait BucketsPath

@JsonCodec case class AverageBucketAggregation extends PipelineAggregationBase

@JsonCodec case class BucketScriptAggregation(
	script: Script
) extends PipelineAggregationBase

@JsonCodec case class BucketSelectorAggregation(
	script: Script
) extends PipelineAggregationBase

@JsonCodec case class BucketSortAggregation(
	from: integer, 
	gap_policy: GapPolicy, 
	size: integer, 
	sort: Sort
) extends Aggregation

@JsonCodec case class CumulativeCardinalityAggregation extends PipelineAggregationBase

@JsonCodec case class CumulativeSumAggregation extends PipelineAggregationBase

@JsonCodec case class DerivativeAggregation extends PipelineAggregationBase

@JsonCodec case class ExtendedStatsBucketAggregation(
	sigma: double
) extends PipelineAggregationBase

@JsonCodec case class InferenceAggregation(
	model_id: Name, 
	inference_config: InferenceConfigContainer
) extends PipelineAggregationBase

@JsonCodec case class InferenceConfigContainer(
	regression: RegressionInferenceOptions, 
	classification: ClassificationInferenceOptions
)

@JsonCodec case class RegressionInferenceOptions(
	results_field: Field, 
	num_top_feature_importance_values: integer
)

@JsonCodec case class ClassificationInferenceOptions(
	num_top_classes: integer, 
	num_top_feature_importance_values: integer, 
	prediction_field_type: String, 
	results_field: String, 
	top_classes_results_field: String
)

@JsonCodec case class MaxBucketAggregation extends PipelineAggregationBase

@JsonCodec case class MinBucketAggregation extends PipelineAggregationBase

@JsonCodec case class MovingAverageAggregation(
	minimize: Boolean, 
	model: MovingAverageModel, 
	settings: MovingAverageSettings, 
	predict: integer, 
	window: integer
) extends PipelineAggregationBase

object MovingAverageModel extends Enumeration {
	type MovingAverageModel = Value

	val linear = Value("linear")
	val simple = Value("simple")
	val ewma = Value("ewma")
	val holt = Value("holt")
	val holt_winters = Value("holt_winters")
}

implicit val movingAverageModelDecoder: Decoder[MovingAverageModel.Value] = Decoder.decodeEnumeration(MovingAverageModel)
implicit val movingAverageModelEncoder: Encoder[MovingAverageModel.Value] = Decoder.encodeEnumeration(MovingAverageModel)
type MovingAverageSettings = EwmaModelSettings | HoltLinearModelSettings | HoltWintersModelSettings

@JsonCodec case class EwmaModelSettings(
	alpha: float
)

@JsonCodec case class HoltLinearModelSettings(
	alpha: float, 
	beta: float
)

@JsonCodec case class HoltWintersModelSettings(
	alpha: float, 
	beta: float, 
	gamma: float, 
	pad: Boolean, 
	period: integer, 
	`type`: HoltWintersType
)

object HoltWintersType extends Enumeration {
	type HoltWintersType = Value

	val add = Value("add")
	val mult = Value("mult")
}

implicit val holtWintersTypeDecoder: Decoder[HoltWintersType.Value] = Decoder.decodeEnumeration(HoltWintersType)
implicit val holtWintersTypeEncoder: Encoder[HoltWintersType.Value] = Decoder.encodeEnumeration(HoltWintersType)

@JsonCodec case class MovingFunctionAggregation(
	script: String, 
	shift: integer, 
	window: integer
) extends PipelineAggregationBase

@JsonCodec case class MovingPercentilesAggregation(
	window: integer, 
	shift: integer
) extends PipelineAggregationBase

@JsonCodec case class NormalizeAggregation(
	method: NormalizeMethod
) extends PipelineAggregationBase

object NormalizeMethod extends Enumeration {
	type NormalizeMethod = Value

	val rescale_0_1 = Value("rescale_0_1")
	val rescale_0_100 = Value("rescale_0_100")
	val percent_of_sum = Value("percent_of_sum")
	val mean = Value("mean")
	val zscore = Value("zscore")
	val softmax = Value("softmax")
}

implicit val normalizeMethodDecoder: Decoder[NormalizeMethod.Value] = Decoder.decodeEnumeration(NormalizeMethod)
implicit val normalizeMethodEncoder: Encoder[NormalizeMethod.Value] = Decoder.encodeEnumeration(NormalizeMethod)

@JsonCodec case class PercentilesBucketAggregation(
	percents: Seq[double]
) extends PipelineAggregationBase

@JsonCodec case class SerialDifferencingAggregation(
	lag: integer
) extends PipelineAggregationBase

@JsonCodec case class StatsBucketAggregation extends PipelineAggregationBase

@JsonCodec case class SumBucketAggregation extends PipelineAggregationBase
