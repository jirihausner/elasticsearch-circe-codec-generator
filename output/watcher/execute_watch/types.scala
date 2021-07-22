package com.converted.elasticsearch.watcher.execute_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._watcher._types.Conditions.{ ConditionContainer }
import com.converted.elasticsearch._watcher._types.Execution.{ ExecutionResult, ExecutionStatus }
import com.converted.elasticsearch._watcher._types.Input.{ InputContainer }
import com.converted.elasticsearch._watcher._types.Trigger.{ TriggerEventResult }
import com.converted.elasticsearch._types.common.{ Id, Metadata, Username }

@JsonCodec case class WatchRecord(
	condition: ConditionContainer, 
	input: InputContainer, 
	messages: Array(String), 
	metadata: Metadata, 
	node: String, 
	result: ExecutionResult, 
	state: ExecutionStatus, 
	trigger_event: TriggerEventResult, 
	user: Username, 
	watch_id: Id
)

