package com.converted.elasticsearch._global.update_by_query_rethrottle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.BaseNode.{ BaseNode }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._task._types.TaskInfo.{ Info }
import com.converted.elasticsearch._types.common.{ TaskId }

@JsonCodec case class UpdateByQueryRethrottleNode(
	tasks: Dictionary(TaskId, Info)
) extends BaseNode
