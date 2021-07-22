package com.converted.elasticsearch._global.search

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.aggregations.Aggregate.{ Aggregate }
import com.converted.elasticsearch._types.common.{ AggregateName, Id, ScrollId, SuggestionName }
import com.converted.elasticsearch._types.Numeric.{ double, long }
import com.converted.elasticsearch._types.Stats.{ ClusterStatistics, ShardStatistics }
import com.converted.elasticsearch._global.search.{ HitsMetadata }
import com.converted.elasticsearch._global.search.{ Profile }
import com.converted.elasticsearch._global.search.{ Suggest }

@JsonCodec case class Response[TDocument](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		took: long, 
		timed_out: Boolean, 
		_shards: ShardStatistics, 
		hits: HitsMetadata[TDocument], 
		aggregations: Dictionary[AggregateName, Aggregate], 
		_clusters: ClusterStatistics, 
		documents: Seq[TDocument], 
		fields: Dictionary[String, UserDefinedValue], 
		max_score: double, 
		num_reduce_phases: long, 
		profile: Profile, 
		pit_id: Id, 
		_scroll_id: ScrollId, 
		suggest: Dictionary[SuggestionName, Seq[Suggest[TDocument]]], 
		terminated_early: Boolean
	)
}

