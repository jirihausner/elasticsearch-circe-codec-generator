package com.converted.elasticsearch.cluster.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cluster._types.ClusterStatus.{ ClusterStatus }
import com.converted.elasticsearch._nodes._types.NodesResponseBase.{ NodesResponseBase }
import com.converted.elasticsearch._types.common.{ Name, Uuid }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch.cluster.stats.{ ClusterIndices, ClusterNodes }

@JsonCodec case class Response(
	body: Body
) extends NodesResponseBase

object Response {
	@JsonCodec case class Body(
		cluster_name: Name, 
		cluster_uuid: Uuid, 
		indices: ClusterIndices, 
		nodes: ClusterNodes, 
		status: ClusterStatus, 
		timestamp: long
	)
}

