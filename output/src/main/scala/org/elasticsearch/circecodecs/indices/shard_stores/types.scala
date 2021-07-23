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

package org.elasticsearch.circecodecs.indices.shard_stores

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ Id, VersionNumber, Name }
import org.elasticsearch.circecodecs.types.Networking.{ TransportAddress }

@JsonCodec case class IndicesShardStores(
	shards: Dictionary[String, ShardStoreWrapper]
)

@JsonCodec case class ShardStore(
	allocation: ShardStoreAllocation, 
	allocation_id: Id, 
	attributes: Dictionary[String, UserDefinedValue], 
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
	stores: Seq[ShardStore]
)
