package com.converted.elasticsearch.snapshot.status

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._snapshot._types.SnapshotStatus.{ Status }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		snapshots: Array(Status)
	)
}

