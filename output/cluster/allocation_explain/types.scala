package com.converted.elasticsearch.cluster.allocation_explain

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Name, Id }
import com.converted.elasticsearch._types.Networking.{ TransportAddress }
import com.converted.elasticsearch._types.Numeric.{ long, double, integer }
import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class AllocationDecision(
	decider: String, 
	decision: AllocationExplainDecision, 
	explanation: String
)

object AllocationExplainDecision extends Enumeration {
	type AllocationExplainDecision = Value

	val nO = Value(0, "NO")
	val yES = Value(1, "YES")
	val tHROTTLE = Value(2, "THROTTLE")
	val aLWAYS = Value(3, "ALWAYS")
}

implicit val allocationExplainDecisionDecoder: Decoder[AllocationExplainDecision.Value] = Decoder.decodeEnumeration(AllocationExplainDecision)
implicit val allocationExplainDecisionEncoder: Encoder[AllocationExplainDecision.Value] = Decoder.encodeEnumeration(AllocationExplainDecision)

@JsonCodec case class AllocationStore(
	allocation_id: String, 
	found: Boolean, 
	in_sync: Boolean, 
	matching_size_in_bytes: long, 
	matching_sync_id: Boolean, 
	store_exception: String
)

@JsonCodec case class ClusterInfo(
	nodes: Dictionary[String, NodeDiskUsage], 
	shard_sizes: Dictionary[String, long], 
	shard_data_set_sizes: Dictionary[String, String], 
	shard_paths: Dictionary[String, String], 
	reserved_sizes: Seq[ReservedSize]
)

@JsonCodec case class NodeDiskUsage(
	node_name: Name, 
	least_available: DiskUsage, 
	most_available: DiskUsage
)

@JsonCodec case class DiskUsage(
	path: String, 
	total_bytes: long, 
	used_bytes: long, 
	free_bytes: long, 
	free_disk_percent: double, 
	used_disk_percent: double
)

@JsonCodec case class ReservedSize(
	node_id: Id, 
	path: String, 
	total: long, 
	shards: Seq[String]
)

@JsonCodec case class CurrentNode(
	id: Id, 
	name: Name, 
	attributes: Dictionary[String, String], 
	transport_address: TransportAddress, 
	weight_ranking: integer
)

object Decision extends Enumeration {
	type Decision = Value

	val yes = Value(0, "yes")
	val no = Value(1, "no")
	val worse_balance = Value(2, "worse_balance")
	val throttled = Value(3, "throttled")
	val awaiting_info = Value(4, "awaiting_info")
	val allocation_delayed = Value(5, "allocation_delayed")
	val no_valid_shard_copy = Value(6, "no_valid_shard_copy")
	val no_attempt = Value(7, "no_attempt")
}

implicit val decisionDecoder: Decoder[Decision.Value] = Decoder.decodeEnumeration(Decision)
implicit val decisionEncoder: Encoder[Decision.Value] = Decoder.encodeEnumeration(Decision)

@JsonCodec case class NodeAllocationExplanation(
	deciders: Seq[AllocationDecision], 
	node_attributes: Dictionary[String, String], 
	node_decision: Decision, 
	node_id: Id, 
	node_name: Name, 
	store: AllocationStore, 
	transport_address: TransportAddress, 
	weight_ranking: integer
)

object StoreCopy extends Enumeration {
	type StoreCopy = Value

	val nONE = Value(0, "NONE")
	val aVAILABLE = Value(1, "AVAILABLE")
	val cORRUPT = Value(2, "CORRUPT")
	val iO_ERROR = Value(3, "IO_ERROR")
	val sTALE = Value(4, "STALE")
	val uNKNOWN = Value(5, "UNKNOWN")
}

implicit val storeCopyDecoder: Decoder[StoreCopy.Value] = Decoder.decodeEnumeration(StoreCopy)
implicit val storeCopyEncoder: Encoder[StoreCopy.Value] = Decoder.encodeEnumeration(StoreCopy)

@JsonCodec case class UnassignedInformation(
	at: DateString, 
	last_allocation_status: String, 
	reason: UnassignedInformationReason, 
	details: String, 
	failed_allocation_attempts: integer, 
	delayed: Boolean, 
	allocation_status: String
)

object UnassignedInformationReason extends Enumeration {
	type UnassignedInformationReason = Value

	val iNDEX_CREATED = Value(0, "INDEX_CREATED")
	val cLUSTER_RECOVERED = Value(1, "CLUSTER_RECOVERED")
	val iNDEX_REOPENED = Value(2, "INDEX_REOPENED")
	val dANGLING_INDEX_IMPORTED = Value(3, "DANGLING_INDEX_IMPORTED")
	val nEW_INDEX_RESTORED = Value(4, "NEW_INDEX_RESTORED")
	val eXISTING_INDEX_RESTORED = Value(5, "EXISTING_INDEX_RESTORED")
	val rEPLICA_ADDED = Value(6, "REPLICA_ADDED")
	val aLLOCATION_FAILED = Value(7, "ALLOCATION_FAILED")
	val nODE_LEFT = Value(8, "NODE_LEFT")
	val rEROUTE_CANCELLED = Value(9, "REROUTE_CANCELLED")
	val rEINITIALIZED = Value(10, "REINITIALIZED")
	val rEALLOCATED_REPLICA = Value(11, "REALLOCATED_REPLICA")
	val pRIMARY_FAILED = Value(12, "PRIMARY_FAILED")
	val fORCED_EMPTY_PRIMARY = Value(13, "FORCED_EMPTY_PRIMARY")
	val mANUAL_ALLOCATION = Value(14, "MANUAL_ALLOCATION")
}

implicit val unassignedInformationReasonDecoder: Decoder[UnassignedInformationReason.Value] = Decoder.decodeEnumeration(UnassignedInformationReason)
implicit val unassignedInformationReasonEncoder: Encoder[UnassignedInformationReason.Value] = Decoder.encodeEnumeration(UnassignedInformationReason)
