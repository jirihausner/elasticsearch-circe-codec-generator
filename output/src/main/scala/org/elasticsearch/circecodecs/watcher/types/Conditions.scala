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

package org.elasticsearch.circecodecs.watcher.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }

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
