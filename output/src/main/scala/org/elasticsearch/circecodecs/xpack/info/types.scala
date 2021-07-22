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

package org.elasticsearch.circecodecs.xpack.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._license._types.License.{ LicenseStatus, LicenseType }
import org.elasticsearch.circecodecs._types.common.{ VersionString }
import org.elasticsearch.circecodecs._types.Time.{ DateString, EpochMillis }

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
