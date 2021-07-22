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
	timestamp: Long, 
	transport: Transport, 
	transport_address: TransportAddress, 
	attributes: Dictionary(Field, String)
)


@JsonCodec case class Ingest(
	pipelines: Dictionary(String, IngestTotal), 
	total: IngestTotal
)


@JsonCodec case class IngestTotal(
	count: Long, 
	current: Long, 
	failed: Long, 
	processors: Array(KeyedProcessor), 
	time_in_millis: Long
)


@JsonCodec case class KeyedProcessor(
	statistics: Process, 
	`type`: String
)


@JsonCodec case class AdaptiveSelection(
	avg_queue_size: Long, 
	avg_response_time: Long, 
	avg_response_time_ns: Long, 
	avg_service_time: String, 
	avg_service_time_ns: Long, 
	outgoing_searches: Long, 
	rank: String
)


@JsonCodec case class Breaker(
	estimated_size: String, 
	estimated_size_in_bytes: Long, 
	limit_size: String, 
	limit_size_in_bytes: Long, 
	overhead: float, 
	tripped: float
)


@JsonCodec case class Cpu(
	percent: integer, 
	sys: String, 
	sys_in_millis: Long, 
	total: String, 
	total_in_millis: Long, 
	user: String, 
	user_in_millis: Long, 
	load_average: Dictionary(String, double)
)


@JsonCodec case class DataPathStats(
	available: String, 
	available_in_bytes: Long, 
	disk_queue: String, 
	disk_reads: Long, 
	disk_read_size: String, 
	disk_read_size_in_bytes: Long, 
	disk_writes: Long, 
	disk_write_size: String, 
	disk_write_size_in_bytes: Long, 
	free: String, 
	free_in_bytes: Long, 
	mount: String, 
	path: String, 
	total: String, 
	total_in_bytes: Long, 
	`type`: String
)


@JsonCodec case class MemoryStats(
	resident: String, 
	resident_in_bytes: Long, 
	share: String, 
	share_in_bytes: Long, 
	total_virtual: String, 
	total_virtual_in_bytes: Long, 
	total_in_bytes: Long, 
	free_in_bytes: Long, 
	used_in_bytes: Long
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
	total_opened: Long
)


@JsonCodec case class FileSystem(
	data: Array(DataPathStats), 
	timestamp: Long, 
	total: FileSystemTotal
)


@JsonCodec case class FileSystemTotal(
	available: String, 
	available_in_bytes: Long, 
	free: String, 
	free_in_bytes: Long, 
	total: String, 
	total_in_bytes: Long
)


@JsonCodec case class NodeBufferPool(
	count: Long, 
	total_capacity: String, 
	total_capacity_in_bytes: Long, 
	used: String, 
	used_in_bytes: Long
)


@JsonCodec case class Jvm(
	buffer_pools: Dictionary(String, NodeBufferPool), 
	classes: JvmClasses, 
	gc: GarbageCollector, 
	mem: MemoryStats, 
	threads: JvmThreads, 
	timestamp: Long, 
	uptime: String, 
	uptime_in_millis: Long
)


@JsonCodec case class JvmThreads(
	count: Long, 
	peak_count: Long
)


@JsonCodec case class JvmClasses(
	current_loaded_count: Long, 
	total_loaded_count: Long, 
	total_unloaded_count: Long
)


@JsonCodec case class GarbageCollector(
	collectors: Dictionary(String, GarbageCollectorTotal)
)


@JsonCodec case class GarbageCollectorTotal(
	collection_count: Long, 
	collection_time: String, 
	collection_time_in_millis: Long
)


@JsonCodec case class OperatingSystem(
	cpu: Cpu, 
	mem: ExtendedMemoryStats, 
	swap: MemoryStats, 
	timestamp: Long
)


@JsonCodec case class Process(
	cpu: Cpu, 
	mem: MemoryStats, 
	open_file_descriptors: integer, 
	timestamp: Long
)


@JsonCodec case class Scripting(
	cache_evictions: Long, 
	compilations: Long
)


@JsonCodec case class ThreadCount(
	active: Long, 
	completed: Long, 
	largest: Long, 
	queue: Long, 
	rejected: Long, 
	threads: Long
)


@JsonCodec case class Transport(
	rx_count: Long, 
	rx_size: String, 
	rx_size_in_bytes: Long, 
	server_open: integer, 
	tx_count: Long, 
	tx_size: String, 
	tx_size_in_bytes: Long
)

