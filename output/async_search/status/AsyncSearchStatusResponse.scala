package com.converted.elasticsearch.async_search.status

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._async_search._types.AsyncSearchResponseBase.{ AsyncSearchResponseBase }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }

@JsonCodec case class Response[TDocument](
	body: Body
) extends AsyncSearchResponseBase

object Response {
	@JsonCodec case class Body(
		_shards: ShardStatistics, 
		completion_status: integer
	)
}

