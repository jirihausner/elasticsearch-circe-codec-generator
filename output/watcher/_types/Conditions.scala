package com.converted.elasticsearch.watcher._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }

@JsonCodec sealed trait AlwaysCondition

@JsonCodec case class ArrayCompareCondition(
	array_path: String, 
	comparison: String, 
	path: String, 
	quantifier: Quantifier, 
	value: UserDefinedValue
)

@JsonCodec case class CompareCondition(
	comparison: String, 
	path: String, 
	value: UserDefinedValue, 
	`ctx.payload.match`: CompareContextPayloadCondition, 
	`ctx.payload.value`: CompareContextPayloadCondition
)

@JsonCodec case class CompareContextPayloadCondition(
	eq: UserDefinedValue, 
	lt: UserDefinedValue, 
	gt: UserDefinedValue, 
	lte: UserDefinedValue, 
	gte: UserDefinedValue
)

@JsonCodec sealed trait Condition

@JsonCodec case class ConditionContainer(
	always: AlwaysCondition, 
	array_compare: ArrayCompareCondition, 
	compare: CompareCondition, 
	never: NeverCondition, 
	script: ScriptCondition
)

object ConditionType extends Enumeration {
	type ConditionType = Value

	val always = Value(0, "always")
	val never = Value(1, "never")
	val script = Value(2, "script")
	val compare = Value(3, "compare")
	val array_compare = Value(4, "array_compare")
}

implicit val conditionTypeDecoder: Decoder[ConditionType.Value] = Decoder.decodeEnumeration(ConditionType)
implicit val conditionTypeEncoder: Encoder[ConditionType.Value] = Decoder.encodeEnumeration(ConditionType)

@JsonCodec sealed trait NeverCondition

object Quantifier extends Enumeration {
	type Quantifier = Value

	val some = Value(0, "some")
	val all = Value(1, "all")
}

implicit val quantifierDecoder: Decoder[Quantifier.Value] = Decoder.decodeEnumeration(Quantifier)
implicit val quantifierEncoder: Encoder[Quantifier.Value] = Decoder.encodeEnumeration(Quantifier)

@JsonCodec case class ScriptCondition(
	lang: String, 
	params: Dictionary[String, UserDefinedValue], 
	source: String
)
