package com.converted.elasticsearch.cluster.allocation_explain

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch.cluster.allocation_explain.{ Decision, AllocationDecision, ClusterInfo, CurrentNode, NodeAllocationExplanation, UnassignedInformation }

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
		can_rebalance_cluster_decisions: Array[AllocationDecision], 
		can_rebalance_to_other_node: Decision, 
		can_remain_decisions: Array[AllocationDecision], 
		can_remain_on_current_node: Decision, 
		cluster_info: ClusterInfo, 
		configured_delay: String, 
		configured_delay_in_millis: long, 
		current_node: CurrentNode, 
		current_state: String, 
		index: IndexName, 
		move_explanation: String, 
		node_allocation_decisions: Array[NodeAllocationExplanation], 
		primary: Boolean, 
		rebalance_explanation: String, 
		remaining_delay: String, 
		remaining_delay_in_millis: long, 
		shard: integer, 
		unassigned_info: UnassignedInformation
	)
}

