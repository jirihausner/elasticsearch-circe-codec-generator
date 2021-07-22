package com.converted.elasticsearch.cat.segments

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ ByteSize, IndexName, NodeId, VersionString }

@JsonCodec case class SegmentsRecord(
	index: IndexName, 
	shard: String, 
	prirep: String, 
	ip: String, 
	id: NodeId, 
	segment: String, 
	generation: String, 
	`docs.count`: String, 
	`docs.deleted`: String, 
	size: ByteSize, 
	`size.memory`: ByteSize, 
	committed: String, 
	searchable: String, 
	version: VersionString, 
	compound: String
)
