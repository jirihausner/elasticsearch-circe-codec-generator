package com.converted.elasticsearch.indices.shard_stores

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Id, VersionNumber, Name }
import com.converted.elasticsearch._types.Networking.{ TransportAddress }

@JsonCodec case class IndicesShardStores(
	shards: Dictionary(String, ShardStoreWrapper)
)

@JsonCodec case class ShardStore(
	allocation: ShardStoreAllocation, 
	allocation_id: Id, 
	attributes: Dictionary(String, UserDefinedValue), 
	id: Id, 
	legacy_version: VersionNumber, 
	name: Name, 
	store_exception: ShardStoreException, 
	transport_address: TransportAddress
)

object ShardStoreAllocation extends Enumeration {
	type ShardStoreAllocation = Value

	val primary = Value(0, "primary")
	val replica = Value(1, "replica")
	val unused = Value(2, "unused")
}

implicit val shardStoreAllocationDecoder: Decoder[ShardStoreAllocation.Value] = Decoder.decodeEnumeration(ShardStoreAllocation)
implicit val shardStoreAllocationEncoder: Encoder[ShardStoreAllocation.Value] = Decoder.encodeEnumeration(ShardStoreAllocation)

@JsonCodec case class ShardStoreException(
	reason: String, 
	`type`: String
)

@JsonCodec case class ShardStoreWrapper(
	stores: Array(ShardStore)
)
