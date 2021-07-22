package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.behaviors.{ AdditionalProperties }
import com.converted.elasticsearch._types.common.{ Field, MinimumShouldMatch }
import com.converted.elasticsearch._types.Geo.{ Distance }
import com.converted.elasticsearch._types.Numeric.{ double, float, long }
import com.converted.elasticsearch._types.Scripting.{ Script }
import com.converted.elasticsearch._types.Time.{ DateMath, Time }
import com.converted.elasticsearch._types.query_dsl.{ QueryBase, QueryContainer }
import com.converted.elasticsearch._types.query_dsl.{ GeoLocation }

@JsonCodec case class BoolQuery(
	filter: QueryContainer | Array(QueryContainer), 
	minimum_should_match: MinimumShouldMatch, 
	must: QueryContainer | Array(QueryContainer), 
	must_not: QueryContainer | Array(QueryContainer), 
	should: QueryContainer | Array(QueryContainer)
) extends QueryBase


@JsonCodec case class BoostingQuery(
	negative_boost: double, 
	negative: QueryContainer, 
	positive: QueryContainer
) extends QueryBase


@JsonCodec case class ConstantScoreQuery(
	filter: QueryContainer
) extends QueryBase


@JsonCodec case class DisMaxQuery(
	queries: Array(QueryContainer), 
	tie_breaker: double
) extends QueryBase


@JsonCodec case class FunctionScoreQuery(
	boost_mode: FunctionBoostMode, 
	functions: Array(FunctionScoreContainer), 
	max_boost: double, 
	min_score: double, 
	query: QueryContainer, 
	score_mode: FunctionScoreMode
) extends QueryBase


@JsonCodec case class ScoreFunctionBase(
	filter: QueryContainer, 
	weight: double
)


@JsonCodec case class WeightScoreFunction extends ScoreFunctionBase


@JsonCodec case class ScriptScoreFunction(
	script: Script
) extends ScoreFunctionBase


@JsonCodec case class RandomScoreFunction(
	field: Field, 
	seed: Long | String
) extends ScoreFunctionBase


@JsonCodec case class FieldValueFactorScoreFunction(
	field: Field, 
	factor: double, 
	missing: double, 
	modifier: FieldValueFactorModifier
) extends ScoreFunctionBase


@JsonCodec case class DecayPlacement[TOrigin, TScale](
	decay: double, 
	offset: TScale, 
	scale: TScale, 
	origin: TOrigin
)


@JsonCodec case class DecayFunctionBase(
	multi_value_mode: MultiValueMode
) extends ScoreFunctionBase


@JsonCodec case class NumericDecayFunction extends DecayFunctionBase, AdditionalProperties(String, DecayPlacement(double, double))


@JsonCodec case class DateDecayFunction extends DecayFunctionBase, AdditionalProperties(String, DecayPlacement(DateMath, Time))


@JsonCodec case class GeoDecayFunction extends DecayFunctionBase, AdditionalProperties(String, DecayPlacement(GeoLocation, Distance))

type DecayFunction = DateDecayFunction | NumericDecayFunction | GeoDecayFunction

@JsonCodec case class FunctionScoreContainer(
	exp: DecayFunction, 
	gauss: DecayFunction, 
	linear: DecayFunction, 
	field_value_factor: FieldValueFactorScoreFunction, 
	random_score: RandomScoreFunction, 
	script_score: ScriptScoreFunction, 
	filter: QueryContainer, 
	weight: double
)


object FunctionScoreMode extends Enumeration {
	type FunctionScoreMode = Value

val multiply = Value(0, "multiply")
val sum = Value(1, "sum")
val avg = Value(2, "avg")
val first = Value(3, "first")
val max = Value(4, "max")
val min = Value(5, "min")
}

implicit val functionScoreModeDecoder: Decoder[FunctionScoreMode.Value] = Decoder.decodeEnumeration(FunctionScoreMode)
implicit val functionScoreModeEncoder: Encoder[FunctionScoreMode.Value] = Decoder.encodeEnumeration(FunctionScoreMode)


object FunctionBoostMode extends Enumeration {
	type FunctionBoostMode = Value

val multiply = Value(0, "multiply")
val replace = Value(1, "replace")
val sum = Value(2, "sum")
val avg = Value(3, "avg")
val max = Value(4, "max")
val min = Value(5, "min")
}

implicit val functionBoostModeDecoder: Decoder[FunctionBoostMode.Value] = Decoder.decodeEnumeration(FunctionBoostMode)
implicit val functionBoostModeEncoder: Encoder[FunctionBoostMode.Value] = Decoder.encodeEnumeration(FunctionBoostMode)


object FieldValueFactorModifier extends Enumeration {
	type FieldValueFactorModifier = Value

val none = Value(0, "none")
val log = Value(1, "log")
val log1p = Value(2, "log1p")
val log2p = Value(3, "log2p")
val ln = Value(4, "ln")
val ln1p = Value(5, "ln1p")
val ln2p = Value(6, "ln2p")
val square = Value(7, "square")
val sqrt = Value(8, "sqrt")
val reciprocal = Value(9, "reciprocal")
}

implicit val fieldValueFactorModifierDecoder: Decoder[FieldValueFactorModifier.Value] = Decoder.decodeEnumeration(FieldValueFactorModifier)
implicit val fieldValueFactorModifierEncoder: Encoder[FieldValueFactorModifier.Value] = Decoder.encodeEnumeration(FieldValueFactorModifier)


object MultiValueMode extends Enumeration {
	type MultiValueMode = Value

val min = Value(0, "min")
val max = Value(1, "max")
val avg = Value(2, "avg")
val sum = Value(3, "sum")
}

implicit val multiValueModeDecoder: Decoder[MultiValueMode.Value] = Decoder.decodeEnumeration(MultiValueMode)
implicit val multiValueModeEncoder: Encoder[MultiValueMode.Value] = Decoder.encodeEnumeration(MultiValueMode)

