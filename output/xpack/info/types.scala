package com.converted.elasticsearch.xpack.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._license._types.License.{ LicenseStatus, LicenseType }
import com.converted.elasticsearch._types.common.{ VersionString }
import com.converted.elasticsearch._types.Time.{ DateString, EpochMillis }

@JsonCodec case class BuildInformation(
	date: DateString, 
	hash: String
)


@JsonCodec case class NativeCodeInformation(
	build_hash: String, 
	version: VersionString
)


@JsonCodec case class MinimalLicenseInformation(
	expiry_date_in_millis: EpochMillis, 
	mode: LicenseType, 
	status: LicenseStatus, 
	`type`: LicenseType, 
	uid: String
)


@JsonCodec case class Features(
	aggregate_metric: Feature, 
	analytics: Feature, 
	ccr: Feature, 
	data_frame: Feature, 
	data_science: Feature, 
	data_streams: Feature, 
	data_tiers: Feature, 
	enrich: Feature, 
	eql: Feature, 
	flattened: Feature, 
	frozen_indices: Feature, 
	graph: Feature, 
	ilm: Feature, 
	logstash: Feature, 
	ml: Feature, 
	monitoring: Feature, 
	rollup: Feature, 
	runtime_fields: Feature, 
	searchable_snapshots: Feature, 
	security: Feature, 
	slm: Feature, 
	spatial: Feature, 
	sql: Feature, 
	transform: Feature, 
	vectors: Feature, 
	voting_only: Feature, 
	watcher: Feature
)


@JsonCodec case class Feature(
	available: Boolean, 
	description: String, 
	enabled: Boolean, 
	native_code_info: NativeCodeInformation
)

