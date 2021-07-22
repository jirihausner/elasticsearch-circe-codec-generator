package com.converted.elasticsearch.cluster.reroute

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cluster._types.ClusterStateMetadata.{ ClusterStateMetadata }
import com.converted.elasticsearch._cluster._types.ClusterStateRoutingNodes.{ ClusterStateRoutingNodes }
import com.converted.elasticsearch._cluster._types.ClusterStateSnapshots.{ ClusterStateSnapshots, ClusterStateDeletedSnapshots }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ EmptyObject, IndexName, NodeName, Uuid, VersionNumber }
import com.converted.elasticsearch._types.Node.{ NodeAttributes }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Command(
	cancel: CommandCancelAction, 
	move: CommandMoveAction, 
	allocate_replica: CommandAllocateReplicaAction, 
	allocate_stale_primary: CommandAllocatePrimaryAction, 
	allocate_empty_primary: CommandAllocatePrimaryAction
)

@JsonCodec case class CommandCancelAction(
	index: IndexName, 
	shard: integer, 
	node: String, 
	allow_primary: Boolean
)

@JsonCodec case class CommandAction(
	index: IndexName, 
	shard: integer, 
	node: String, 
	allow_primary: Boolean
)

@JsonCodec case class CommandMoveAction(
	index: IndexName, 
	shard: integer, 
	from_node: String, 
	to_node: String
)

@JsonCodec case class CommandAllocateReplicaAction(
	index: IndexName, 
	shard: integer, 
	node: String
)

@JsonCodec case class CommandAllocatePrimaryAction(
	index: IndexName, 
	shard: integer, 
	node: String, 
	accept_data_loss: Boolean
)

@JsonCodec case class RerouteDecision(
	decider: String, 
	decision: String, 
	explanation: String
)

@JsonCodec case class RerouteExplanation(
	command: String, 
	decisions: Array[RerouteDecision], 
	parameters: RerouteParameters
)

@JsonCodec case class RerouteParameters(
	allow_primary: Boolean, 
	index: IndexName, 
	node: NodeName, 
	shard: integer, 
	from_node: NodeName, 
	to_node: NodeName
)

@JsonCodec case class RerouteState(
	cluster_uuid: Uuid, 
	state_uuid: Uuid, 
	master_node: String, 
	version: VersionNumber, 
	blocks: EmptyObject, 
	nodes: Dictionary[NodeName, NodeAttributes], 
	routing_table: Dictionary[String, EmptyObject], 
	routing_nodes: ClusterStateRoutingNodes, 
	security_tokens: Dictionary[String, String], 
	snapshots: ClusterStateSnapshots, 
	snapshot_deletions: ClusterStateDeletedSnapshots, 
	metadata: ClusterStateMetadata
)
