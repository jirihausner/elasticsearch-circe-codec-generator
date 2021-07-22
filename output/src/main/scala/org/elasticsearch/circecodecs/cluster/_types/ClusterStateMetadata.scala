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

package org.elasticsearch.circecodecs.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.common.{ Id, IndexName, Name, Uuid }
import org.elasticsearch.circecodecs._types.Numeric.{ integer, long }
import org.elasticsearch.circecodecs._types.Time.{ DateString }
import org.elasticsearch.circecodecs.cluster._types.{ ClusterStateBlockIndex }
import org.elasticsearch.circecodecs.cluster._types.{ ClusterStateIndexLifecycle }
import org.elasticsearch.circecodecs.cluster._types.{ ClusterStateIngest }

@JsonCodec case class ClusterStateMetadata(
	cluster_uuid: Uuid, 
	cluster_uuid_committed: Boolean, 
	templates: ClusterStateMetadataTemplate, 
	indices: Dictionary[IndexName, ClusterStateBlockIndex], 
	`index-graveyard`: ClusterStateMetadataIndexGraveyard, 
	cluster_coordination: ClusterStateMetadataClusterCoordination, 
	ingest: ClusterStateIngest, 
	repositories: Dictionary[String, String], 
	component_template: Dictionary[String, UserDefinedValue], 
	index_template: Dictionary[String, UserDefinedValue], 
	index_lifecycle: ClusterStateIndexLifecycle
)

@JsonCodec case class ClusterStateMetadataIndexGraveyard(
	tombstones: Seq[Tombstone]
)

@JsonCodec case class Tombstone(
	index: TombstoneIndex, 
	delete_date: DateString, 
	delete_date_in_millis: long
)

@JsonCodec case class TombstoneIndex(
	index_name: Name, 
	index_uuid: Uuid
)

@JsonCodec sealed trait ClusterStateMetadataTemplate

@JsonCodec case class ClusterStateMetadataClusterCoordination(
	term: integer, 
	last_committed_config: Seq[String], 
	last_accepted_config: Seq[String], 
	voting_config_exclusions: Seq[VotingConfigExclusionsItem]
)

@JsonCodec case class VotingConfigExclusionsItem(
	node_id: Id, 
	node_name: Name
)
