package com.converted.elasticsearch.cluster.health

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Health, IndexName }
import com.converted.elasticsearch._types.Numeric.{ integer, Percentage }
import com.converted.elasticsearch._types.Time.{ EpochMillis }
import com.converted.elasticsearch.cluster.health.{ IndexHealthStats }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		active_primary_shards: integer, 
		active_shards: integer, 
		active_shards_percent_as_number: Percentage, 
		cluster_name: String, 
		delayed_unassigned_shards: integer, 
		indices: Dictionary(IndexName, IndexHealthStats), 
		initializing_shards: integer, 
		number_of_data_nodes: integer, 
		number_of_in_flight_fetch: integer, 
		number_of_nodes: integer, 
		number_of_pending_tasks: integer, 
		relocating_shards: integer, 
		status: Health, 
		task_max_waiting_in_queue_millis: EpochMillis, 
		timed_out: Boolean, 
		unassigned_shards: integer
	)
}

