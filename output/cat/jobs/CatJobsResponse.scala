package com.converted.elasticsearch.cat.jobs

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.jobs.{ JobsRecord }

@JsonCodec case class Response(
	body: Seq[JobsRecord]
)
