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

package org.elasticsearch.circecodecs.snapshot.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.common.{ IndexName, Metadata, Name, Uuid, VersionNumber, VersionString }
import org.elasticsearch.circecodecs.types.Stats.{ ShardStatistics }
import org.elasticsearch.circecodecs.types.Time.{ EpochMillis, Time }
import org.elasticsearch.circecodecs.snapshot.types.{ IndexDetails }
import org.elasticsearch.circecodecs.snapshot.types.{ InfoFeatureState }
import org.elasticsearch.circecodecs.snapshot.types.{ SnapshotShardFailure }

@JsonCodec case class SnapshotInfo(
	data_streams: Seq[String], 
	duration: Time, 
	duration_in_millis: EpochMillis, 
	end_time: Time, 
	end_time_in_millis: EpochMillis, 
	failures: Seq[SnapshotShardFailure], 
	include_global_state: Boolean, 
	indices: Seq[IndexName], 
	index_details: Dictionary[IndexName, IndexDetails], 
	metadata: Metadata, 
	reason: String, 
	snapshot: Name, 
	shards: ShardStatistics, 
	start_time: Time, 
	start_time_in_millis: EpochMillis, 
	state: String, 
	uuid: Uuid, 
	version: VersionString, 
	version_id: VersionNumber, 
	feature_states: Seq[InfoFeatureState]
)
