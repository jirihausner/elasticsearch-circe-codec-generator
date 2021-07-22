package com.converted.elasticsearch.indices.data_streams_stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ ByteSize, Name }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		_shards: ShardStatistics, 
		backing_indices: integer, 
		data_stream_count: integer, 
		total_store_sizes: ByteSize, 
		total_store_size_bytes: integer, 
		data_streams: Array(DataStreamsStatsItem)
	)
}


@JsonCodec case class DataStreamsStatsItem(
	backing_indices: integer, 
	data_stream: Name, 
	store_size: ByteSize, 
	store_size_bytes: integer, 
	maximum_timestamp: integer
)
