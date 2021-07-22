package com.converted.elasticsearch.watcher.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Node.{ NodeStatistics }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch.watcher.stats.{ WatcherNodeStats }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		cluster_name: Name, 
		manually_stopped: Boolean, 
		stats: Array[WatcherNodeStats], 
		_nodes: NodeStatistics
	)
}

