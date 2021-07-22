package com.converted.elasticsearch.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Id, IndexName, Name, Uuid }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Time.{ DateString }
import com.converted.elasticsearch.cluster._types.{ ClusterStateBlockIndex }
import com.converted.elasticsearch.cluster._types.{ ClusterStateIndexLifecycle }
import com.converted.elasticsearch.cluster._types.{ ClusterStateIngest }

@JsonCodec case class ClusterStateMetadata(
	cluster_uuid: Uuid, 
	cluster_uuid_committed: Boolean, 
	templates: ClusterStateMetadataTemplate, 
	indices: Dictionary(IndexName, ClusterStateBlockIndex), 
	`index-graveyard`: ClusterStateMetadataIndexGraveyard, 
	cluster_coordination: ClusterStateMetadataClusterCoordination, 
	ingest: ClusterStateIngest, 
	repositories: Dictionary(String, String), 
	component_template: Dictionary(String, UserDefinedValue), 
	index_template: Dictionary(String, UserDefinedValue), 
	index_lifecycle: ClusterStateIndexLifecycle
)

@JsonCodec case class ClusterStateMetadataIndexGraveyard(
	tombstones: Array(Tombstone)
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
	last_committed_config: Array(String), 
	last_accepted_config: Array(String), 
	voting_config_exclusions: Array(VotingConfigExclusionsItem)
)

@JsonCodec case class VotingConfigExclusionsItem(
	node_id: Id, 
	node_name: Name
)
