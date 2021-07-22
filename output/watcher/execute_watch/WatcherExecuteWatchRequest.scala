package com.converted.elasticsearch.watcher.execute_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._watcher._types.Action.{ ActionExecutionMode, SimulatedActions }
import com.converted.elasticsearch._watcher._types.Schedule.{ ScheduleTriggerEvent }
import com.converted.elasticsearch._watcher._types.Watch.{ Watch }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id
	)
	@JsonCodec case class QueryParameters(
		debug: Boolean
	)
	@JsonCodec case class Body(
		action_modes: Dictionary[String, ActionExecutionMode], 
		alternative_input: Dictionary[String, UserDefinedValue], 
		ignore_condition: Boolean, 
		record_execution: Boolean, 
		simulated_actions: SimulatedActions, 
		trigger_data: ScheduleTriggerEvent, 
		watch: Watch
	)
}

