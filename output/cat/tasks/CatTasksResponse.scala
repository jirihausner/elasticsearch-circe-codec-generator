package com.converted.elasticsearch.cat.tasks

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.tasks.{ TasksRecord }

@JsonCodec case class Response(
	body: Seq[TasksRecord]
)
