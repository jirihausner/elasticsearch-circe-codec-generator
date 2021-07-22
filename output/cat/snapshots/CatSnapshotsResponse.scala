package com.converted.elasticsearch.cat.snapshots

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.snapshots.{ SnapshotsRecord }

@JsonCodec case class Response(
	body: Array(SnapshotsRecord)
)
