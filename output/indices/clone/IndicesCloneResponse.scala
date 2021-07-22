package com.converted.elasticsearch.indices.clone

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ AcknowledgedResponseBase }
import com.converted.elasticsearch._types.common.{ IndexName }

@JsonCodec case class Response(
	body: Body
) extends AcknowledgedResponseBase

object Response {
	@JsonCodec case class Body(
		index: IndexName, 
		shards_acknowledged: Boolean
	)
}

