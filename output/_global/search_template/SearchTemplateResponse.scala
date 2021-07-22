package com.converted.elasticsearch._global.search_template

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.hits.{ HitsMetadata }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }

@JsonCodec case class Response[TDocument](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		_shards: ShardStatistics, 
		timed_out: Boolean, 
		took: integer, 
		hits: HitsMetadata[TDocument]
	)
}

