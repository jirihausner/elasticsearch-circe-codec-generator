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

package org.elasticsearch.circecodecs.watcher._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.common.{ Id }
import org.elasticsearch.circecodecs._types.Numeric.{ integer, long }
import org.elasticsearch.circecodecs._types.Time.{ DateString }
import org.elasticsearch.circecodecs.watcher._types.{ ActionStatusOptions, ActionType }
import org.elasticsearch.circecodecs.watcher._types.{ EmailResult, IndexResult, LoggingResult, PagerDutyResult, SlackResult, WebhookResult }
import org.elasticsearch.circecodecs.watcher._types.{ ConditionType }
import org.elasticsearch.circecodecs.watcher._types.{ InputType }

object ExecutionStatus extends Enumeration {
	type ExecutionStatus = Value

	val awaits_execution = Value(0, "awaits_execution")
	val checking = Value(1, "checking")
	val execution_not_needed = Value(2, "execution_not_needed")
	val throttled = Value(3, "throttled")
	val executed = Value(4, "executed")
	val failed = Value(5, "failed")
	val deleted_while_queued = Value(6, "deleted_while_queued")
	val not_executed_already_queued = Value(7, "not_executed_already_queued")
}

implicit val executionStatusDecoder: Decoder[ExecutionStatus.Value] = Decoder.decodeEnumeration(ExecutionStatus)
implicit val executionStatusEncoder: Encoder[ExecutionStatus.Value] = Decoder.encodeEnumeration(ExecutionStatus)

object ExecutionPhase extends Enumeration {
	type ExecutionPhase = Value

	val awaits_execution = Value(0, "awaits_execution")
	val started = Value(1, "started")
	val input = Value(2, "input")
	val condition = Value(3, "condition")
	val actions = Value(4, "actions")
	val watch_transform = Value(5, "watch_transform")
	val aborted = Value(6, "aborted")
	val finished = Value(7, "finished")
}

implicit val executionPhaseDecoder: Decoder[ExecutionPhase.Value] = Decoder.decodeEnumeration(ExecutionPhase)
implicit val executionPhaseEncoder: Encoder[ExecutionPhase.Value] = Decoder.encodeEnumeration(ExecutionPhase)

@JsonCodec case class ExecutionResult(
	actions: Seq[ExecutionResultAction], 
	condition: ExecutionResultCondition, 
	execution_duration: integer, 
	execution_time: DateString, 
	input: ExecutionResultInput
)

@JsonCodec case class ExecutionResultCondition(
	met: Boolean, 
	status: ActionStatusOptions, 
	`type`: ConditionType
)

@JsonCodec case class ExecutionResultAction(
	email: EmailResult, 
	id: Id, 
	index: IndexResult, 
	logging: LoggingResult, 
	pagerduty: PagerDutyResult, 
	reason: String, 
	slack: SlackResult, 
	status: ActionStatusOptions, 
	`type`: ActionType, 
	webhook: WebhookResult
)

@JsonCodec case class ExecutionResultInput(
	payload: Dictionary[String, UserDefinedValue], 
	status: ActionStatusOptions, 
	`type`: InputType
)

@JsonCodec case class ExecutionThreadPool(
	max_size: long, 
	queue_size: long
)
