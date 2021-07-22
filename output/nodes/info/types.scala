package com.converted.elasticsearch.nodes.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.IndexRouting.{ IndexRouting }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ ByteSize, Name, VersionString }
import com.converted.elasticsearch._types.Networking.{ Host, Ip, TransportAddress }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Stats.{ PluginStats }
import com.converted.elasticsearch._types.Node.{ NodeRoles }

@JsonCodec case class NodeInfo(
	attributes: Dictionary(String, String), 
	build_flavor: String, 
	build_hash: String, 
	build_type: String, 
	host: Host, 
	http: NodeInfoHttp, 
	ip: Ip, 
	jvm: NodeJvmInfo, 
	name: Name, 
	network: NodeInfoNetwork, 
	os: NodeOperatingSystemInfo, 
	plugins: Array(PluginStats), 
	process: NodeProcessInfo, 
	roles: NodeRoles, 
	settings: NodeInfoSettings, 
	thread_pool: Dictionary(String, NodeThreadPoolInfo), 
	total_indexing_buffer: long, 
	total_indexing_buffer_in_bytes: ByteSize, 
	transport: NodeInfoTransport, 
	transport_address: TransportAddress, 
	version: VersionString, 
	modules: Array(PluginStats), 
	ingest: NodeInfoIngest, 
	aggregations: Dictionary(String, NodeInfoAggregation)
)


@JsonCodec case class NodeInfoSettings(
	cluster: NodeInfoSettingsCluster, 
	node: NodeInfoSettingsNode, 
	path: NodeInfoPath, 
	repositories: NodeInfoRepositories, 
	discovery: NodeInfoDiscover, 
	action: NodeInfoAction, 
	client: NodeInfoClient, 
	http: NodeInfoSettingsHttp, 
	bootstrap: NodeInfoBootstrap, 
	transport: NodeInfoSettingsTransport, 
	network: NodeInfoSettingsNetwork, 
	xpack: NodeInfoXpack, 
	script: NodeInfoScript, 
	search: NodeInfoSearch
)


@JsonCodec case class NodeInfoSettingsCluster(
	name: Name, 
	routing: IndexRouting, 
	election: NodeInfoSettingsClusterElection, 
	initial_master_nodes: String
)


@JsonCodec case class NodeInfoSettingsClusterElection(
	strategy: Name
)


@JsonCodec case class NodeInfoSettingsNode(
	name: Name, 
	attr: Dictionary(String, UserDefinedValue), 
	max_local_storage_nodes: String
)


@JsonCodec case class NodeInfoPath(
	logs: String, 
	home: String, 
	repo: Array(String), 
	data: Array(String)
)


@JsonCodec case class NodeInfoRepositories(
	url: NodeInfoRepositoriesUrl
)


@JsonCodec case class NodeInfoRepositoriesUrl(
	allowed_urls: String
)


@JsonCodec case class NodeInfoDiscover(
	seed_hosts: String
)


@JsonCodec case class NodeInfoAction(
	destructive_requires_name: String
)


@JsonCodec case class NodeInfoClient(
	`type`: String
)


@JsonCodec case class NodeInfoSettingsHttp(
	`type`: String | NodeInfoSettingsHttpType, 
	`type.default`: String, 
	compression: Boolean | String, 
	port: integer | String
)


@JsonCodec case class NodeInfoSettingsHttpType(
	default: String
)


@JsonCodec case class NodeInfoBootstrap(
	memory_lock: String
)


@JsonCodec case class NodeInfoSettingsTransport(
	`type`: String | NodeInfoSettingsTransportType, 
	`type.default`: String, 
	features: NodeInfoSettingsTransportFeatures
)


@JsonCodec case class NodeInfoSettingsTransportType(
	default: String
)


@JsonCodec case class NodeInfoSettingsTransportFeatures(
	`x-pack`: String
)


@JsonCodec case class NodeInfoSettingsNetwork(
	host: Host
)


@JsonCodec case class NodeInfoIngest(
	processors: Array(NodeInfoIngestProcessor)
)


@JsonCodec case class NodeInfoIngestProcessor(
	`type`: String
)


@JsonCodec case class NodeInfoAggregation(
	types: Array(String)
)


@JsonCodec case class NodeInfoXpack(
	license: NodeInfoXpackLicense, 
	security: NodeInfoXpackSecurity, 
	notification: Dictionary(String, UserDefinedValue)
)


@JsonCodec case class NodeInfoXpackSecurity(
	http: NodeInfoXpackSecuritySsl, 
	enabled: String, 
	transport: NodeInfoXpackSecuritySsl, 
	authc: NodeInfoXpackSecurityAuthc
)


@JsonCodec case class NodeInfoXpackSecuritySsl(
	ssl: Dictionary(String, String)
)


@JsonCodec case class NodeInfoXpackSecurityAuthc(
	realms: NodeInfoXpackSecurityAuthcRealms, 
	token: NodeInfoXpackSecurityAuthcToken
)


@JsonCodec case class NodeInfoXpackSecurityAuthcRealms(
	file: Dictionary(String, NodeInfoXpackSecurityAuthcRealmsStatus), 
	native: Dictionary(String, NodeInfoXpackSecurityAuthcRealmsStatus), 
	pki: Dictionary(String, NodeInfoXpackSecurityAuthcRealmsStatus)
)


@JsonCodec case class NodeInfoXpackSecurityAuthcToken(
	enabled: String
)


@JsonCodec case class NodeInfoXpackSecurityAuthcRealmsStatus(
	enabled: String, 
	order: String
)


@JsonCodec case class NodeInfoXpackLicense(
	self_generated: NodeInfoXpackLicenseType
)


@JsonCodec case class NodeInfoXpackLicenseType(
	`type`: String
)


@JsonCodec case class NodeInfoScript(
	allowed_types: String, 
	disable_max_compilations_rate: String
)


@JsonCodec case class NodeInfoSearch(
	remote: NodeInfoSearchRemote
)


@JsonCodec case class NodeInfoSearchRemote(
	connect: String
)


@JsonCodec case class NodeThreadPoolInfo(
	core: integer, 
	keep_alive: String, 
	max: integer, 
	queue_size: integer, 
	size: integer, 
	`type`: String
)


@JsonCodec case class NodeInfoHttp(
	bound_address: Array(String), 
	max_content_length: ByteSize, 
	max_content_length_in_bytes: long, 
	publish_address: String
)


@JsonCodec case class NodeInfoJvmMemory(
	direct_max: ByteSize, 
	direct_max_in_bytes: long, 
	heap_init: ByteSize, 
	heap_init_in_bytes: long, 
	heap_max: ByteSize, 
	heap_max_in_bytes: long, 
	non_heap_init: ByteSize, 
	non_heap_init_in_bytes: long, 
	non_heap_max: ByteSize, 
	non_heap_max_in_bytes: long
)


@JsonCodec case class NodeInfoMemory(
	total: String, 
	total_in_bytes: long
)


@JsonCodec case class NodeInfoNetwork(
	primary_interface: NodeInfoNetworkInterface, 
	refresh_interval: integer
)


@JsonCodec case class NodeInfoNetworkInterface(
	address: String, 
	mac_address: String, 
	name: Name
)


@JsonCodec case class NodeInfoOSCPU(
	cache_size: String, 
	cache_size_in_bytes: integer, 
	cores_per_socket: integer, 
	mhz: integer, 
	model: String, 
	total_cores: integer, 
	total_sockets: integer, 
	vendor: String
)


@JsonCodec case class NodeInfoTransport(
	bound_address: Array(String), 
	publish_address: String, 
	profiles: Dictionary(String, String)
)


@JsonCodec case class NodeJvmInfo(
	gc_collectors: Array(String), 
	mem: NodeInfoJvmMemory, 
	memory_pools: Array(String), 
	pid: integer, 
	start_time_in_millis: long, 
	version: VersionString, 
	vm_name: Name, 
	vm_vendor: String, 
	vm_version: VersionString, 
	bundled_jdk: Boolean, 
	using_bundled_jdk: Boolean, 
	using_compressed_ordinary_object_pointers: Boolean | String, 
	input_arguments: Array(String)
)


@JsonCodec case class NodeOperatingSystemInfo(
	arch: String, 
	available_processors: integer, 
	allocated_processors: integer, 
	name: Name, 
	pretty_name: Name, 
	refresh_interval_in_millis: integer, 
	version: VersionString, 
	cpu: NodeInfoOSCPU, 
	mem: NodeInfoMemory, 
	swap: NodeInfoMemory
)


@JsonCodec case class NodeProcessInfo(
	id: long, 
	mlockall: Boolean, 
	refresh_interval_in_millis: long
)

