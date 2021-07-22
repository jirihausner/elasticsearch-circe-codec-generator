package com.converted.elasticsearch.cat.health

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.health.{ HealthRecord }

@JsonCodec case class Response(
	body: Seq[HealthRecord]
)
