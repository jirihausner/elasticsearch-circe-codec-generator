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
		responses: Seq[SnapshotResponseItem], 
		snapshots: Seq[SnapshotInfo]
	)
}


@JsonCodec case class SnapshotResponseItem(
	repository: Name, 
	snapshots: Seq[SnapshotInfo], 
	error: ErrorCause
)
