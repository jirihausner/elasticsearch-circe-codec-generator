package com.converted.elasticsearch.async_search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.hits.{ HitsMetadata }
import com.converted.elasticsearch._global.search._types.profile.{ Profile }
import com.converted.elasticsearch._global.search._types.suggester.{ Suggest }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.aggregations.Aggregate.{ Aggregate }
import com.converted.elasticsearch._types.common.{ Id, SuggestionName }
import com.converted.elasticsearch._types.Numeric.{ double, long }
import com.converted.elasticsearch._types.Stats.{ ClusterStatistics, ShardStatistics }

@JsonCodec case class AsyncSearch[TDocument](
	aggregations: Dictionary(String, Aggregate), 
	_clusters: ClusterStatistics, 
	fields: Dictionary(String, UserDefinedValue), 
	hits: HitsMetadata(TDocument), 
	max_score: double, 
	num_reduce_phases: long, 
	profile: Profile, 
	pit_id: Id, 
	_scroll_id: Id, 
	_shards: ShardStatistics, 
	suggest: Dictionary(SuggestionName, Array(Suggest(TDocument))), 
	terminated_early: Boolean, 
	timed_out: Boolean, 
	took: long
)
