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

package org.elasticsearch.circecodecs.ml.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.common.{ Field }
import org.elasticsearch.circecodecs.types.Numeric.{ double }
import org.elasticsearch.circecodecs.ml.types.{ FilterRef }

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
