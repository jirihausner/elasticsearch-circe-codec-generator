package com.converted.elasticsearch.watcher.delete_watch

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id, VersionNumber }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		found: Boolean, 
		_id: Id, 
		_version: VersionNumber
	)
}

