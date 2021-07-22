package com.converted.elasticsearch.indices.flush_synced

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }

@JsonCodec case class Response(
	body: Body
) extends DictionaryResponseBase(IndexName, ShardStatistics)

object Response {
	@JsonCodec case class Body(
		_shards: ShardStatistics
	)
}

