package com.converted.elasticsearch.snapshot.create

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._snapshot._types.SnapshotInfo.{ SnapshotInfo }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		accepted: Boolean, 
		snapshot: SnapshotInfo
	)
}

