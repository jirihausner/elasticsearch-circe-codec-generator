package com.converted.elasticsearch.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._snapshot._types.SnapshotStatus.{ Status }

@JsonCodec case class ClusterStateSnapshots(
	snapshots: Seq[Status]
)

@JsonCodec case class ClusterStateDeletedSnapshots(
	snapshot_deletions: Seq[String]
)
