package com.converted.elasticsearch.indices.recovery

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ ByteSize, Id, IndexName, Name, Type, Uuid, VersionString }
import com.converted.elasticsearch._types.Networking.{ Host, TransportAddress, Ip }
import com.converted.elasticsearch._types.Numeric.{ long, Percentage }
import com.converted.elasticsearch._types.Time.{ Time, EpochMillis, DateString }

@JsonCodec case class RecoveryBytes(
	percent: Percentage, 
	recovered: ByteSize, 
	recovered_in_bytes: ByteSize, 
	reused: ByteSize, 
	reused_in_bytes: ByteSize, 
	total: ByteSize, 
	total_in_bytes: ByteSize
)


@JsonCodec case class FileDetails(
	length: long, 
	name: String, 
	recovered: long
)


@JsonCodec case class RecoveryFiles(
	details: Array(FileDetails), 
	percent: Percentage, 
	recovered: long, 
	reused: long, 
	total: long
)


@JsonCodec case class RecoveryIndexStatus(
	bytes: RecoveryBytes, 
	files: RecoveryFiles, 
	size: RecoveryBytes, 
	source_throttle_time: Time, 
	source_throttle_time_in_millis: EpochMillis, 
	target_throttle_time: Time, 
	target_throttle_time_in_millis: EpochMillis, 
	total_time_in_millis: EpochMillis, 
	total_time: Time
)


@JsonCodec case class RecoveryOrigin(
	hostname: String, 
	host: Host, 
	transport_address: TransportAddress, 
	id: Id, 
	ip: Ip, 
	name: Name, 
	bootstrap_new_history_uuid: Boolean, 
	repository: Name, 
	snapshot: Name, 
	version: VersionString, 
	restoreUUID: Uuid, 
	index: IndexName
)


@JsonCodec case class RecoveryStartStatus(
	check_index_time: long, 
	total_time_in_millis: String
)


@JsonCodec case class RecoveryStatus(
	shards: Array(ShardRecovery)
)


@JsonCodec case class TranslogStatus(
	percent: Percentage, 
	recovered: long, 
	total: long, 
	total_on_start: long, 
	total_time: String, 
	total_time_in_millis: EpochMillis
)


@JsonCodec case class VerifyIndex(
	check_index_time: Time, 
	check_index_time_in_millis: EpochMillis, 
	total_time: Time, 
	total_time_in_millis: EpochMillis
)


@JsonCodec case class ShardRecovery(
	id: long, 
	index: RecoveryIndexStatus, 
	primary: Boolean, 
	source: RecoveryOrigin, 
	stage: String, 
	start: RecoveryStartStatus, 
	start_time: DateString, 
	start_time_in_millis: EpochMillis, 
	stop_time: DateString, 
	stop_time_in_millis: EpochMillis, 
	target: RecoveryOrigin, 
	total_time: DateString, 
	total_time_in_millis: EpochMillis, 
	translog: TranslogStatus, 
	`type`: Type, 
	verify_index: VerifyIndex
)

