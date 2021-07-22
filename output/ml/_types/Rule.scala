package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Numeric.{ double }
import com.converted.elasticsearch.ml._types.{ FilterRef }

@JsonCodec case class DetectionRule(
	actions: Seq[RuleAction], 
	conditions: Seq[RuleCondition], 
	scope: Dictionary[Field, FilterRef]
)

object RuleAction extends Enumeration {
	type RuleAction = Value

	val skip_result = Value(0, "skip_result")
	val skip_model_update = Value(1, "skip_model_update")
}

implicit val ruleActionDecoder: Decoder[RuleAction.Value] = Decoder.decodeEnumeration(RuleAction)
implicit val ruleActionEncoder: Encoder[RuleAction.Value] = Decoder.encodeEnumeration(RuleAction)

@JsonCodec case class RuleCondition(
	applies_to: AppliesTo, 
	operator: ConditionOperator, 
	value: double
)

object AppliesTo extends Enumeration {
	type AppliesTo = Value

	val actual = Value(0, "actual")
	val typical = Value(1, "typical")
	val diff_from_typical = Value(2, "diff_from_typical")
	val time = Value(3, "time")
}

implicit val appliesToDecoder: Decoder[AppliesTo.Value] = Decoder.decodeEnumeration(AppliesTo)
implicit val appliesToEncoder: Encoder[AppliesTo.Value] = Decoder.encodeEnumeration(AppliesTo)

object ConditionOperator extends Enumeration {
	type ConditionOperator = Value

	val gt = Value(0, "gt")
	val gte = Value(1, "gte")
	val lt = Value(2, "lt")
	val lte = Value(3, "lte")
}

implicit val conditionOperatorDecoder: Decoder[ConditionOperator.Value] = Decoder.decodeEnumeration(ConditionOperator)
implicit val conditionOperatorEncoder: Encoder[ConditionOperator.Value] = Decoder.encodeEnumeration(ConditionOperator)
