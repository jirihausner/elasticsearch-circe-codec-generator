package com.converted.elasticsearch.watcher.ack_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._watcher._types.Watch.{ WatchStatus }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		status: WatchStatus
	)
}

