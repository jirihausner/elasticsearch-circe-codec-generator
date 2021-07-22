package com.converted.elasticsearch.ml.get_calendars

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch.ml.get_calendars.{ Calendar }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		calendars: Array(Calendar), 
		count: long
	)
}

