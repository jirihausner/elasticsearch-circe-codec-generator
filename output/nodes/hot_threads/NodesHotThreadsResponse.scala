package com.converted.elasticsearch.nodes.hot_threads

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.nodes.hot_threads.{ HotThread }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		hot_threads: Seq[HotThread]
	)
}

