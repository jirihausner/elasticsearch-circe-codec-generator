package com.converted.elasticsearch.watcher.put_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._watcher._types.Action.{ Action }
import com.converted.elasticsearch._watcher._types.Conditions.{ ConditionContainer }
import com.converted.elasticsearch._watcher._types.Input.{ InputContainer }
import com.converted.elasticsearch._watcher._types.Trigger.{ TriggerContainer }
import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id, Metadata, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Transform.{ TransformContainer }

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
		active: Boolean, 
		if_primary_term: long, 
		if_sequence_number: long, 
		version: VersionNumber
	)
	@JsonCodec case class Body(
		actions: Dictionary(String, Action), 
		condition: ConditionContainer, 
		input: InputContainer, 
		metadata: Metadata, 
		throttle_period: String, 
		transform: TransformContainer, 
		trigger: TriggerContainer
	)
}

