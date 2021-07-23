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
import org.elasticsearch.circecodecs.types.common.{ IndexName, Metadata, VersionNumber }
import org.elasticsearch.circecodecs.types.Numeric.{ long }
import org.elasticsearch.circecodecs.types.Time.{ DateString }
import org.elasticsearch.circecodecs.types.Transform.{ TransformContainer }
import org.elasticsearch.circecodecs.watcher.types.{ Action, Actions }
import org.elasticsearch.circecodecs.watcher.types.{ ActivationState }
import org.elasticsearch.circecodecs.watcher.types.{ ConditionContainer }
import org.elasticsearch.circecodecs.watcher.types.{ InputContainer }
import org.elasticsearch.circecodecs.watcher.types.{ TriggerContainer }

@JsonCodec case class Watch(
	actions: Dictionary[IndexName, Action], 
	condition: ConditionContainer, 
	input: InputContainer, 
	metadata: Metadata, 
	status: WatchStatus, 
	throttle_period: String, 
	transform: TransformContainer, 
	trigger: TriggerContainer, 
	throttle_period_in_millis: long
)

@JsonCodec case class WatchStatus(
	actions: Actions, 
	last_checked: DateString, 
	last_met_condition: DateString, 
	state: ActivationState, 
	version: VersionNumber, 
	execution_state: String
)
