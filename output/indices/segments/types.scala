package com.converted.elasticsearch.indices.segments

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ VersionString }
import com.converted.elasticsearch._types.Numeric.{ long, integer, double }

@JsonCodec case class IndexSegment(
	shards: Dictionary(String, ShardsSegment | Array(ShardsSegment))
)

@JsonCodec case class Segment(
	attributes: Dictionary(String, String), 
	committed: Boolean, 
	compound: Boolean, 
	deleted_docs: long, 
	generation: integer, 
	memory_in_bytes: double, 
	search: Boolean, 
	size_in_bytes: double, 
	num_docs: long, 
	version: VersionString
)

@JsonCodec case class ShardSegmentRouting(
	node: String, 
	primary: Boolean, 
	state: String
)

@JsonCodec case class ShardsSegment(
	num_committed_segments: integer, 
	routing: ShardSegmentRouting, 
	num_search_segments: integer, 
	segments: Dictionary(String, Segment)
)
