package com.converted.elasticsearch.indices.reload_search_analyzers

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Stats.{ ShardStatistics }
import com.converted.elasticsearch.indices.reload_search_analyzers.{ ReloadDetails }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		reload_details: Array(ReloadDetails), 
		_shards: ShardStatistics
	)
}

