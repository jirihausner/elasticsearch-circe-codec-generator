package com.converted.elasticsearch.ml.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.ml.info.{ Defaults, Limits, NativeCode }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		defaults: Defaults, 
		limits: Limits, 
		upgrade_mode: Boolean, 
		native_code: NativeCode
	)
}

