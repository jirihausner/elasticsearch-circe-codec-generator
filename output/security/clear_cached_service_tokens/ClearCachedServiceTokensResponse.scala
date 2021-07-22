package com.converted.elasticsearch.security.clear_cached_service_tokens

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.ClusterNode.{ ClusterNode }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch._types.Node.{ NodeStatistics }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		_nodes: NodeStatistics, 
		cluster_name: Name, 
		nodes: Dictionary[String, ClusterNode]
	)
}

