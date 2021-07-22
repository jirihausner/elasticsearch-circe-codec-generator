package com.converted.elasticsearch.cluster.health

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Health }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class IndexHealthStats(
	active_primary_shards: integer, 
	active_shards: integer, 
	initializing_shards: integer, 
	number_of_replicas: integer, 
	number_of_shards: integer, 
	relocating_shards: integer, 
	shards: Dictionary(String, ShardHealthStats), 
	status: Health, 
	unassigned_shards: integer
)


@JsonCodec case class ShardHealthStats(
	active_shards: integer, 
	initializing_shards: integer, 
	primary_active: Boolean, 
	relocating_shards: integer, 
	status: Health, 
	unassigned_shards: integer
)

