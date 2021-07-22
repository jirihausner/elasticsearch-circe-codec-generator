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

package org.elasticsearch.circecodecs.cluster.state

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._cluster._types.ClusterStateBlocksIndex.{ ClusterStateBlockIndex }
import org.elasticsearch.circecodecs._cluster._types.ClusterStateMetadata.{ ClusterStateMetadata }
import org.elasticsearch.circecodecs._cluster._types.ClusterStateRoutingNodes.{ ClusterStateRoutingNodes }
import org.elasticsearch.circecodecs._cluster._types.ClusterStateSnapshots.{ ClusterStateDeletedSnapshots, ClusterStateSnapshots }
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ EmptyObject, IndexName, Name, NodeName, Uuid, VersionNumber }
import org.elasticsearch.circecodecs._types.Node.{ NodeAttributes }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		cluster_name: Name, 
		cluster_uuid: Uuid, 
		master_node: String, 
		state: Seq[String], 
		state_uuid: Uuid, 
		version: VersionNumber, 
		blocks: ClusterStateBlocks, 
		metadata: ClusterStateMetadata, 
		nodes: Dictionary[NodeName, NodeAttributes], 
		routing_table: Dictionary[String, EmptyObject], 
		routing_nodes: ClusterStateRoutingNodes, 
		snapshots: ClusterStateSnapshots, 
		snapshot_deletions: ClusterStateDeletedSnapshots
	)
}


@JsonCodec case class ClusterStateBlocks(
	indices: Dictionary[IndexName, Dictionary[String, ClusterStateBlockIndex]]
)
