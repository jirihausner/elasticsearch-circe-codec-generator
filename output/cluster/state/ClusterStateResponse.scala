package com.converted.elasticsearch.cluster.state

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cluster._types.ClusterStateBlocksIndex.{ ClusterStateBlockIndex }
import com.converted.elasticsearch._cluster._types.ClusterStateMetadata.{ ClusterStateMetadata }
import com.converted.elasticsearch._cluster._types.ClusterStateRoutingNodes.{ ClusterStateRoutingNodes }
import com.converted.elasticsearch._cluster._types.ClusterStateSnapshots.{ ClusterStateDeletedSnapshots, ClusterStateSnapshots }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ EmptyObject, IndexName, Name, NodeName, Uuid, VersionNumber }
import com.converted.elasticsearch._types.Node.{ NodeAttributes }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		cluster_name: Name, 
		cluster_uuid: Uuid, 
		master_node: String, 
		state: Array(String), 
		state_uuid: Uuid, 
		version: VersionNumber, 
		blocks: ClusterStateBlocks, 
		metadata: ClusterStateMetadata, 
		nodes: Dictionary(NodeName, NodeAttributes), 
		routing_table: Dictionary(String, EmptyObject), 
		routing_nodes: ClusterStateRoutingNodes, 
		snapshots: ClusterStateSnapshots, 
		snapshot_deletions: ClusterStateDeletedSnapshots
	)
}


@JsonCodec case class ClusterStateBlocks(
	indices: Dictionary(IndexName, Dictionary(String, ClusterStateBlockIndex))
)
