package com.converted.elasticsearch.indices.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }
import com.converted.elasticsearch.indices.stats.{ IndicesStats }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		indices: Dictionary(String, IndicesStats), 
		_shards: ShardStatistics, 
		_all: IndicesStats
	)
}

