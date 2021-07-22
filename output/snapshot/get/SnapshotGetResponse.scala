package com.converted.elasticsearch.snapshot.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._snapshot._types.SnapshotInfo.{ SnapshotInfo }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch._types.Errors.{ ErrorCause }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		responses: Array(SnapshotResponseItem), 
		snapshots: Array(SnapshotInfo)
	)
}


@JsonCodec case class SnapshotResponseItem(
	repository: Name, 
	snapshots: Array(SnapshotInfo), 
	error: ErrorCause
)

