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

package org.elasticsearch.circecodecs.ilm.explain_lifecycle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.common.{ IndexName, Name, VersionNumber }
import org.elasticsearch.circecodecs._types.Numeric.{ integer }
import org.elasticsearch.circecodecs._types.Time.{ EpochMillis, Time }

@JsonCodec case class LifecycleExplain(
	action: Name, 
	action_time_millis: EpochMillis, 
	age: Time, 
	failed_step: Name, 
	failed_step_retry_count: integer, 
	index: IndexName, 
	is_auto_retryable_error: Boolean, 
	lifecycle_date_millis: EpochMillis, 
	managed: Boolean, 
	phase: Name, 
	phase_time_millis: EpochMillis, 
	policy: Name, 
	step: Name, 
	step_info: Dictionary[String, UserDefinedValue], 
	step_time_millis: EpochMillis, 
	phase_execution: LifecycleExplainPhaseExecution
)

@JsonCodec case class LifecycleExplainPhaseExecution(
	policy: Name, 
	version: VersionNumber, 
	modified_date_in_millis: EpochMillis
)

@JsonCodec case class LifecycleExplainProject(
	project: LifecycleExplainProjectSummary
)

@JsonCodec case class LifecycleExplainProjectSummary(
	index: IndexName, 
	managed: Boolean
)
