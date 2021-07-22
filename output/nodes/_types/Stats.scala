package com.converted.elasticsearch.nodes._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices.stats.types.{ IndexStats }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field, Name }
import com.converted.elasticsearch._types.Networking.{ Host, Ip, TransportAddress }
import com.converted.elasticsearch._types.Node.{ NodeRoles }
import com.converted.elasticsearch._types.Numeric.{ double, float, integer, long }

@JsonCodec case class Stats(
	adaptive_selection: Dictionary(String, AdaptiveSelection), 
	breakers: Dictionary(String, Breaker), 
	fs: FileSystem, 
	host: Host, 
	http: Http, 
	indices: IndexStats, 
	ingest: Ingest, 
	ip: Ip | Array(Ip), 
	jvm: Jvm, 
	name: Name, 
	os: OperatingSystem, 
	process: Process, 
	roles: NodeRoles, 
	script: Scripting, 
	thread_pool: Dictionary(String, ThreadCount), 
	timestamp: long, 
	transport: Transport, 
	transport_address: TransportAddress, 
	attributes: Dictionary(Field, String)
)


@JsonCodec case class Ingest(
	pipelines: Dictionary(String, IngestTotal), 
	total: IngestTotal
)


@JsonCodec case class IngestTotal(
	count: long, 
	current: long, 
	failed: long, 
	processors: Array(KeyedProcessor), 
	time_in_millis: long
)


@JsonCodec case class KeyedProcessor(
	statistics: Process, 
	`type`: String
)


@JsonCodec case class AdaptiveSelection(
	avg_queue_size: long, 
	avg_response_time: long, 
	avg_response_time_ns: long, 
	avg_service_time: String, 
	avg_service_time_ns: long, 
	outgoing_searches: long, 
	rank: String
)


@JsonCodec case class Breaker(
	estimated_size: String, 
	estimated_size_in_bytes: long, 
	limit_size: String, 
	limit_size_in_bytes: long, 
	overhead: float, 
	tripped: float
)


@JsonCodec case class Cpu(
	percent: integer, 
	sys: String, 
	sys_in_millis: long, 
	total: String, 
	total_in_millis: long, 
	user: String, 
	user_in_millis: long, 
	load_average: Dictionary(String, double)
)


@JsonCodec case class DataPathStats(
	available: String, 
	available_in_bytes: long, 
	disk_queue: String, 
	disk_reads: long, 
	disk_read_size: String, 
	disk_read_size_in_bytes: long, 
	disk_writes: long, 
	disk_write_size: String, 
	disk_write_size_in_bytes: long, 
	free: String, 
	free_in_bytes: long, 
	mount: String, 
	path: String, 
	total: String, 
	total_in_bytes: long, 
	`type`: String
)


@JsonCodec case class MemoryStats(
	resident: String, 
	resident_in_bytes: long, 
	share: String, 
	share_in_bytes: long, 
	total_virtual: String, 
	total_virtual_in_bytes: long, 
	total_in_bytes: long, 
	free_in_bytes: long, 
	used_in_bytes: long
)


@JsonCodec case class ExtendedMemoryStats(
	free_percent: integer, 
	used_percent: integer, 
	total_in_bytes: integer, 
	free_in_bytes: integer, 
	used_in_bytes: integer
) extends MemoryStats


@JsonCodec case class Http(
	current_open: integer, 
	total_opened: long
)


@JsonCodec case class FileSystem(
	data: Array(DataPathStats), 
	timestamp: long, 
	total: FileSystemTotal
)


@JsonCodec case class FileSystemTotal(
	available: String, 
	available_in_bytes: long, 
	free: String, 
	free_in_bytes: long, 
	total: String, 
	total_in_bytes: long
)


@JsonCodec case class NodeBufferPool(
	count: long, 
	total_capacity: String, 
	total_capacity_in_bytes: long, 
	used: String, 
	used_in_bytes: long
)


@JsonCodec case class Jvm(
	buffer_pools: Dictionary(String, NodeBufferPool), 
	classes: JvmClasses, 
	gc: GarbageCollector, 
	mem: MemoryStats, 
	threads: JvmThreads, 
	timestamp: long, 
	uptime: String, 
	uptime_in_millis: long
)


@JsonCodec case class JvmThreads(
	count: long, 
	peak_count: long
)


@JsonCodec case class JvmClasses(
	current_loaded_count: long, 
	total_loaded_count: long, 
	total_unloaded_count: long
)


@JsonCodec case class GarbageCollector(
	collectors: Dictionary(String, GarbageCollectorTotal)
)


@JsonCodec case class GarbageCollectorTotal(
	collection_count: long, 
	collection_time: String, 
	collection_time_in_millis: long
)


@JsonCodec case class OperatingSystem(
	cpu: Cpu, 
	mem: ExtendedMemoryStats, 
	swap: MemoryStats, 
	timestamp: long
)


@JsonCodec case class Process(
	cpu: Cpu, 
	mem: MemoryStats, 
	open_file_descriptors: integer, 
	timestamp: long
)


@JsonCodec case class Scripting(
	cache_evictions: long, 
	compilations: long
)


@JsonCodec case class ThreadCount(
	active: long, 
	completed: long, 
	largest: long, 
	queue: long, 
	rejected: long, 
	threads: long
)


@JsonCodec case class Transport(
	rx_count: long, 
	rx_size: String, 
	rx_size_in_bytes: long, 
	server_open: integer, 
	tx_count: long, 
	tx_size: String, 
	tx_size_in_bytes: long
)

