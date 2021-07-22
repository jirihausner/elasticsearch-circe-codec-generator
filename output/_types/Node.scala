package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._cluster.allocation_explain.types.{ UnassignedInformation }
import com.converted.elasticsearch._indices.stats.types.{ ShardRoutingState }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Errors.{ ErrorCause }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.{ Id, IndexName, Name, NodeName }
import com.converted.elasticsearch._types.{ TransportAddress }

@JsonCodec case class NodeStatistics(
	failures: Array[ErrorCause], 
	total: integer, 
	successful: integer, 
	failed: integer
)

@JsonCodec case class NodeAttributes(
	attributes: Dictionary[String, String], 
	ephemeral_id: Id, 
	id: Id, 
	name: NodeName, 
	transport_address: TransportAddress, 
	roles: NodeRoles
)

@JsonCodec case class NodeShard(
	state: ShardRoutingState, 
	primary: Boolean, 
	node: NodeName, 
	shard: integer, 
	index: IndexName, 
	allocation_id: Dictionary[String, Id], 
	recovery_source: Dictionary[String, Id], 
	unassigned_info: UnassignedInformation
)

object NodeRole extends Enumeration {
	type NodeRole = Value

	val master = Value(0, "master")
	val data = Value(1, "data")
	val data_cold = Value(2, "data_cold")
	val data_content = Value(3, "data_content")
	val data_frozen = Value(4, "data_frozen")
	val data_hot = Value(5, "data_hot")
	val data_warm = Value(6, "data_warm")
	val client = Value(7, "client")
	val ingest = Value(8, "ingest")
	val ml = Value(9, "ml")
	val voting_only = Value(10, "voting_only")
	val transform = Value(11, "transform")
	val remote_cluster_client = Value(12, "remote_cluster_client")
	val coordinating_only = Value(13, "coordinating_only")
}

implicit val nodeRoleDecoder: Decoder[NodeRole.Value] = Decoder.decodeEnumeration(NodeRole)
implicit val nodeRoleEncoder: Encoder[NodeRole.Value] = Decoder.encodeEnumeration(NodeRole)
type NodeRoles = Array[NodeRole]
