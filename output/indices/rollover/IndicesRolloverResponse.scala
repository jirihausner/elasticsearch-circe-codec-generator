package com.converted.elasticsearch.indices.rollover

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ AcknowledgedResponseBase }

@JsonCodec case class Response(
	body: Body
) extends AcknowledgedResponseBase

object Response {
	@JsonCodec case class Body(
		conditions: Dictionary[String, Boolean], 
		dry_run: Boolean, 
		new_index: String, 
		old_index: String, 
		rolled_over: Boolean, 
		shards_acknowledged: Boolean
	)
}

