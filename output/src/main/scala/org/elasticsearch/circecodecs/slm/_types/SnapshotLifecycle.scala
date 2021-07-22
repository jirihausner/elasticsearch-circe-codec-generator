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

package org.elasticsearch.circecodecs.slm._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._watcher._types.Schedule.{ CronExpression }
import org.elasticsearch.circecodecs._types.common.{ Id, Indices, Name, Uuid, VersionNumber }
import org.elasticsearch.circecodecs._types.Numeric.{ integer, long }
import org.elasticsearch.circecodecs._types.Time.{ DateString, EpochMillis, Time }

@JsonCodec case class SnapshotLifecycle(
	in_progress: InProgress, 
	last_failure: Invocation, 
	last_success: Invocation, 
	modified_date: DateString, 
	modified_date_millis: EpochMillis, 
	next_execution: DateString, 
	next_execution_millis: EpochMillis, 
	policy: Policy, 
	version: VersionNumber, 
	stats: Statistics
)

@JsonCodec case class Statistics(
	retention_deletion_time: DateString, 
	retention_deletion_time_millis: EpochMillis, 
	retention_failed: long, 
	retention_runs: long, 
	retention_timed_out: long, 
	policy: Id, 
	total_snapshots_deleted: long, 
	total_snapshot_deletion_failures: long, 
	total_snapshots_failed: long, 
	total_snapshots_taken: long
)

@JsonCodec case class Policy(
	config: Configuration, 
	name: Name, 
	repository: String, 
	retention: Retention, 
	schedule: CronExpression
)

@JsonCodec case class Retention(
	expire_after: Time, 
	max_count: integer, 
	min_count: integer
)

@JsonCodec case class Configuration(
	ignore_unavailable: Boolean, 
	include_global_state: Boolean, 
	indices: Indices
)

@JsonCodec case class InProgress(
	name: Name, 
	start_time_millis: DateString, 
	state: String, 
	uuid: Uuid
)

@JsonCodec case class Invocation(
	snapshot_name: Name, 
	time: DateString
)
