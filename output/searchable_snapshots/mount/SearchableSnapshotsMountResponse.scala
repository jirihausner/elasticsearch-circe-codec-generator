package com.converted.elasticsearch.searchable_snapshots.mount

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.searchable_snapshots.mount.{ MountedSnapshot }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		snapshot: MountedSnapshot
	)
}

