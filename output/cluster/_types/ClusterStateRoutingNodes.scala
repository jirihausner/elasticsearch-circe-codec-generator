package com.converted.elasticsearch.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Node.{ NodeShard }

@JsonCodec case class ClusterStateRoutingNodes(
	unassigned: Seq[NodeShard], 
	nodes: Dictionary[String, Seq[NodeShard]]
)
