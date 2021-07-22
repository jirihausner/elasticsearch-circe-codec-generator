package com.converted.elasticsearch.cat.thread_pool

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.thread_pool.{ ThreadPoolRecord }

@JsonCodec case class Response(
	body: Seq[ThreadPoolRecord]
)
