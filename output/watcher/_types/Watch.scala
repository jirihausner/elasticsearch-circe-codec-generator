package com.converted.elasticsearch.watcher._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ IndexName, Metadata, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ DateString }
import com.converted.elasticsearch._types.Transform.{ TransformContainer }
import com.converted.elasticsearch.watcher._types.{ Action, Actions }
import com.converted.elasticsearch.watcher._types.{ ActivationState }
import com.converted.elasticsearch.watcher._types.{ ConditionContainer }
import com.converted.elasticsearch.watcher._types.{ InputContainer }
import com.converted.elasticsearch.watcher._types.{ TriggerContainer }

@JsonCodec case class Watch(
	actions: Dictionary(IndexName, Action), 
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
