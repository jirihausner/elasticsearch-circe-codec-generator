package com.converted.elasticsearch.ilm.move_to_step

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch.ilm.move_to_step.{ StepKey }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		index: IndexName
	)
	@JsonCodec case class Body(
		current_step: StepKey, 
		next_step: StepKey
	)
}

