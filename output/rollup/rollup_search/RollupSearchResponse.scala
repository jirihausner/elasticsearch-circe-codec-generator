package com.converted.elasticsearch.rollup.rollup_search

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.hits.{ HitsMetadata }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.aggregations.Aggregate.{ Aggregate }
import com.converted.elasticsearch._types.common.{ AggregateName }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }

@JsonCodec case class Response[TDocument](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		took: long, 
		timed_out: Boolean, 
		terminated_early: Boolean, 
		_shards: ShardStatistics, 
		hits: HitsMetadata(TDocument), 
		aggregations: Dictionary(AggregateName, Aggregate)
	)
}

