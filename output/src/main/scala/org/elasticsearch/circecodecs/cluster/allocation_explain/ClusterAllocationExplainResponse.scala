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

package org.elasticsearch.circecodecs.cluster.allocation_explain

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.common.{ IndexName }
import org.elasticsearch.circecodecs.types.Numeric.{ integer, long }
import org.elasticsearch.circecodecs.cluster.allocation_explain.{ Decision, AllocationDecision, ClusterInfo, CurrentNode, NodeAllocationExplanation, UnassignedInformation }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		allocate_explanation: String, 
		allocation_delay: String, 
		allocation_delay_in_millis: long, 
		can_allocate: Decision, 
		can_move_to_other_node: Decision, 
		can_rebalance_cluster: Decision, 
		can_rebalance_cluster_decisions: Seq[AllocationDecision], 
		can_rebalance_to_other_node: Decision, 
		can_remain_decisions: Seq[AllocationDecision], 
		can_remain_on_current_node: Decision, 
		cluster_info: ClusterInfo, 
		configured_delay: String, 
		configured_delay_in_millis: long, 
		current_node: CurrentNode, 
		current_state: String, 
		index: IndexName, 
		move_explanation: String, 
		node_allocation_decisions: Seq[NodeAllocationExplanation], 
		primary: Boolean, 
		rebalance_explanation: String, 
		remaining_delay: String, 
		remaining_delay_in_millis: long, 
		shard: integer, 
		unassigned_info: UnassignedInformation
	)
}
