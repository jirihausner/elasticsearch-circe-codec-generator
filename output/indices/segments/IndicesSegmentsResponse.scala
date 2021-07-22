package com.converted.elasticsearch.indices.segments

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }
import com.converted.elasticsearch.indices.segments.{ IndexSegment }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		indices: Dictionary(String, IndexSegment), 
		_shards: ShardStatistics
	)
}

