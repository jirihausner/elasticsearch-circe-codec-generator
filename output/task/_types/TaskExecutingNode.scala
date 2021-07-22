package com.converted.elasticsearch.task._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.BaseNode.{ BaseNode }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ TaskId }
import com.converted.elasticsearch.task._types.{ State }

@JsonCodec case class TaskExecutingNode(
	tasks: Dictionary[TaskId, State]
) extends BaseNode
