package com.converted.elasticsearch.nodes.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Metrics, NodeIds }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		node_id: NodeIds, 
		metric: Metrics
	)
	@JsonCodec case class QueryParameters(
		flat_settings: Boolean, 
		master_timeout: Time, 
		timeout: Time
	)
}

