/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.circecodecs.cluster.reroute

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._cluster._types.ClusterStateMetadata.{ ClusterStateMetadata }
import org.elasticsearch.circecodecs._cluster._types.ClusterStateRoutingNodes.{ ClusterStateRoutingNodes }
import org.elasticsearch.circecodecs._cluster._types.ClusterStateSnapshots.{ ClusterStateSnapshots, ClusterStateDeletedSnapshots }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ EmptyObject, IndexName, NodeName, Uuid, VersionNumber }
import org.elasticsearch.circecodecs._types.Node.{ NodeAttributes }
import org.elasticsearch.circecodecs._types.Numeric.{ integer }

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
	decisions: Seq[RerouteDecision], 
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
