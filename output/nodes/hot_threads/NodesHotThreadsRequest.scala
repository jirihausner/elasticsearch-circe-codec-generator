package com.converted.elasticsearch.nodes.hot_threads

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ NodeIds, ThreadType }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		node_id: NodeIds
	)
	@JsonCodec case class QueryParameters(
		ignore_idle_threads: Boolean, 
		interval: Time, 
		snapshots: Long, 
		threads: Long, 
		thread_type: ThreadType, 
		timeout: Time
	)
}

