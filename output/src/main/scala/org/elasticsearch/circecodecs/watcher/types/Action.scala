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
import org.elasticsearch.circecodecs.types.common.{ IndexName, Name }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }
import org.elasticsearch.circecodecs.types.Time.{ DateString, EpochMillis, Time }
import org.elasticsearch.circecodecs.types.Transform.{ TransformContainer }
import org.elasticsearch.circecodecs.watcher.types.{ Index, Logging }
import org.elasticsearch.circecodecs.watcher.types.{ ConditionContainer }

@JsonCodec case class Action(
	action_type: ActionType, 
	condition: ConditionContainer, 
	foreach: String, 
	max_iterations: integer, 
	name: Name, 
	throttle_period: Time, 
	throttle_period_in_millis: EpochMillis, 
	transform: TransformContainer, 
	index: Index, 
	logging: Logging
)
type Actions = Dictionary[IndexName, ActionStatus]

object ActionType extends Enumeration {
	type ActionType = Value

	val email = Value(0, "email")
	val webhook = Value(1, "webhook")
	val index = Value(2, "index")
	val logging = Value(3, "logging")
	val slack = Value(4, "slack")
	val pagerduty = Value(5, "pagerduty")
}

implicit val actionTypeDecoder: Decoder[ActionType.Value] = Decoder.decodeEnumeration(ActionType)
implicit val actionTypeEncoder: Encoder[ActionType.Value] = Decoder.encodeEnumeration(ActionType)

object ActionExecutionMode extends Enumeration {
	type ActionExecutionMode = Value

	val simulate = Value(0, "simulate")
	val force_simulate = Value(1, "force_simulate")
	val execute = Value(2, "execute")
	val force_execute = Value(3, "force_execute")
	val skip = Value(4, "skip")
}

implicit val actionExecutionModeDecoder: Decoder[ActionExecutionMode.Value] = Decoder.decodeEnumeration(ActionExecutionMode)
implicit val actionExecutionModeEncoder: Encoder[ActionExecutionMode.Value] = Decoder.encodeEnumeration(ActionExecutionMode)

@JsonCodec case class SimulatedActions(
	actions: Seq[String], 
	all: SimulatedActions, 
	use_all: Boolean
)

object ActionStatusOptions extends Enumeration {
	type ActionStatusOptions = Value

	val success = Value(0, "success")
	val failure = Value(1, "failure")
	val simulated = Value(2, "simulated")
	val throttled = Value(3, "throttled")
}

implicit val actionStatusOptionsDecoder: Decoder[ActionStatusOptions.Value] = Decoder.decodeEnumeration(ActionStatusOptions)
implicit val actionStatusOptionsEncoder: Encoder[ActionStatusOptions.Value] = Decoder.encodeEnumeration(ActionStatusOptions)

object AcknowledgementOptions extends Enumeration {
	type AcknowledgementOptions = Value

	val awaits_successful_execution = Value(0, "awaits_successful_execution")
	val ackable = Value(1, "ackable")
	val acked = Value(2, "acked")
}

implicit val acknowledgementOptionsDecoder: Decoder[AcknowledgementOptions.Value] = Decoder.decodeEnumeration(AcknowledgementOptions)
implicit val acknowledgementOptionsEncoder: Encoder[AcknowledgementOptions.Value] = Decoder.encodeEnumeration(AcknowledgementOptions)

@JsonCodec case class AcknowledgeState(
	state: AcknowledgementOptions, 
	timestamp: DateString
)

@JsonCodec case class ExecutionState(
	successful: Boolean, 
	timestamp: DateString
)

@JsonCodec case class ThrottleState(
	reason: String, 
	timestamp: DateString
)

@JsonCodec case class ActionStatus(
	ack: AcknowledgeState, 
	last_execution: ExecutionState, 
	last_successful_execution: ExecutionState, 
	last_throttle: ThrottleState
)
