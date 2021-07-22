package com.converted.elasticsearch._global.update

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ InlineGet }
import com.converted.elasticsearch._types.Base.{ WriteResponseBase }

@JsonCodec case class Response[TDocument](
	body: Body
) extends WriteResponseBase

object Response {
	@JsonCodec case class Body(
		get: InlineGet(TDocument)
	)
}

