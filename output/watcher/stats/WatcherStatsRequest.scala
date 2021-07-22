package com.converted.elasticsearch.watcher.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch.watcher.stats.{ WatcherMetric }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		metric: WatcherMetric | Seq[WatcherMetric]
	)
	@JsonCodec case class QueryParameters(
		emit_stacktraces: Boolean, 
		metric: WatcherMetric | Seq[WatcherMetric]
	)
}

