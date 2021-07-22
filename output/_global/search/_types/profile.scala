package com.converted.elasticsearch._global.search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class AggregationBreakdown(
	build_aggregation: Long, 
	build_aggregation_count: Long, 
	build_leaf_collector: Long, 
	build_leaf_collector_count: Long, 
	collect: Long, 
	collect_count: Long, 
	initialize: Long, 
	initialize_count: Long, 
	post_collection: Long, 
	post_collection_count: Long, 
	reduce: Long, 
	reduce_count: Long
)


@JsonCodec sealed trait AggregationProfileDebug


@JsonCodec case class AggregationProfile(
	breakdown: AggregationBreakdown, 
	description: String, 
	time_in_nanos: Long, 
	`type`: String, 
	debug: AggregationProfileDebug, 
	children: Array(AggregationProfileDebug)
)


@JsonCodec case class Collector(
	name: String, 
	reason: String, 
	time_in_nanos: Long, 
	children: Array(Collector)
)


@JsonCodec case class Profile(
	shards: Array(ShardProfile)
)


@JsonCodec case class QueryBreakdown(
	advance: Long, 
	advance_count: Long, 
	build_scorer: Long, 
	build_scorer_count: Long, 
	create_weight: Long, 
	create_weight_count: Long, 
	`match`: Long, 
	match_count: Long, 
	shallow_advance: Long, 
	shallow_advance_count: Long, 
	next_doc: Long, 
	next_doc_count: Long, 
	score: Long, 
	score_count: Long, 
	compute_max_score: Long, 
	compute_max_score_count: Long, 
	set_min_competitive_score: Long, 
	set_min_competitive_score_count: Long
)


@JsonCodec case class QueryProfile(
	breakdown: QueryBreakdown, 
	description: String, 
	time_in_nanos: Long, 
	`type`: String, 
	children: Array(QueryProfile)
)


@JsonCodec case class SearchProfile(
	collector: Array(Collector), 
	query: Array(QueryProfile), 
	rewrite_time: Long
)


@JsonCodec case class ShardProfile(
	aggregations: Array(AggregationProfile), 
	id: String, 
	searches: Array(SearchProfile)
)

