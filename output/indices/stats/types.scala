package com.converted.elasticsearch.indices.stats

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Uuid, Id, SequenceNumber, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Stats.{ BulkStats, CompletionStats, DocStats, FielddataStats, FlushStats, GetStats, IndexingStats, MergesStats, QueryCacheStats, RecoveryStats, RefreshStats, RequestCacheStats, SearchStats, SegmentsStats, StoreStats, TranslogStats, WarmerStats }

@JsonCodec case class IndexStats(
	completion: CompletionStats, 
	docs: DocStats, 
	fielddata: FielddataStats, 
	flush: FlushStats, 
	get: GetStats, 
	indexing: IndexingStats, 
	merges: MergesStats, 
	query_cache: QueryCacheStats, 
	recovery: RecoveryStats, 
	refresh: RefreshStats, 
	request_cache: RequestCacheStats, 
	search: SearchStats, 
	segments: SegmentsStats, 
	store: StoreStats, 
	translog: TranslogStats, 
	warmer: WarmerStats, 
	bulk: BulkStats
)

@JsonCodec case class IndicesStats(
	primaries: IndexStats, 
	shards: Dictionary[String, Array[ShardStats]], 
	total: IndexStats, 
	uuid: Uuid
)

@JsonCodec case class ShardCommit(
	generation: integer, 
	id: Id, 
	num_docs: long, 
	user_data: Dictionary[String, String]
)

@JsonCodec case class ShardFielddata(
	evictions: long, 
	memory_size_in_bytes: long
)

@JsonCodec case class ShardFileSizeInfo(
	description: String, 
	size_in_bytes: long, 
	min_size_in_bytes: long, 
	max_size_in_bytes: long, 
	average_size_in_bytes: long, 
	count: long
)

@JsonCodec case class ShardLease(
	id: Id, 
	retaining_seq_no: SequenceNumber, 
	timestamp: long, 
	source: String
)

@JsonCodec case class ShardPath(
	data_path: String, 
	is_custom_data_path: Boolean, 
	state_path: String
)

@JsonCodec case class ShardQueryCache(
	cache_count: long, 
	cache_size: long, 
	evictions: long, 
	hit_count: long, 
	memory_size_in_bytes: long, 
	miss_count: long, 
	total_count: long
)

@JsonCodec case class ShardRetentionLeases(
	primary_term: long, 
	version: VersionNumber, 
	leases: Array[ShardLease]
)

@JsonCodec case class ShardRouting(
	node: String, 
	primary: Boolean, 
	relocating_node: String, 
	state: ShardRoutingState
)

object ShardRoutingState extends Enumeration {
	type ShardRoutingState = Value

	val uNASSIGNED = Value(0, "UNASSIGNED")
	val iNITIALIZING = Value(1, "INITIALIZING")
	val sTARTED = Value(2, "STARTED")
	val rELOCATING = Value(3, "RELOCATING")
}

implicit val shardRoutingStateDecoder: Decoder[ShardRoutingState.Value] = Decoder.decodeEnumeration(ShardRoutingState)
implicit val shardRoutingStateEncoder: Encoder[ShardRoutingState.Value] = Decoder.encodeEnumeration(ShardRoutingState)

@JsonCodec case class ShardSequenceNumber(
	global_checkpoint: long, 
	local_checkpoint: long, 
	max_seq_no: SequenceNumber
)

@JsonCodec case class ShardStats(
	commit: ShardCommit, 
	completion: CompletionStats, 
	docs: DocStats, 
	fielddata: FielddataStats, 
	flush: FlushStats, 
	get: GetStats, 
	indexing: IndexingStats, 
	merges: MergesStats, 
	shard_path: ShardPath, 
	query_cache: ShardQueryCache, 
	recovery: RecoveryStats, 
	refresh: RefreshStats, 
	request_cache: RequestCacheStats, 
	retention_leases: ShardRetentionLeases, 
	routing: ShardRouting, 
	search: SearchStats, 
	segments: SegmentsStats, 
	seq_no: ShardSequenceNumber, 
	store: StoreStats, 
	translog: TranslogStats, 
	warmer: WarmerStats, 
	bulk: BulkStats
)
