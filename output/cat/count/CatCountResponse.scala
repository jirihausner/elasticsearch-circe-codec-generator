package com.converted.elasticsearch.cat.count

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.count.{ CountRecord }

@JsonCodec case class Response(
	body: Array(CountRecord)
)
