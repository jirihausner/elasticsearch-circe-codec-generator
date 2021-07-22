package com.converted.elasticsearch._global.explain

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, IndexName, Type, InlineGet }
import com.converted.elasticsearch._global.explain.{ ExplanationDetail }

@JsonCodec case class Response[TDocument](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		_index: IndexName, 
		_type: Type, 
		_id: Id, 
		matched: Boolean, 
		explanation: ExplanationDetail, 
		get: InlineGet[TDocument]
	)
}

