package com.converted.elasticsearch.cluster._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices.rollover.types.{ RolloverConditions }
import com.converted.elasticsearch._indices._types.IndexSettings.{ IndexSettings }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ IndexAlias, IndexName, VersionNumber }
import com.converted.elasticsearch._types.mapping.TypeMapping.{ TypeMapping }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class ClusterStateBlockIndex(
	description: String, 
	retryable: Boolean, 
	levels: Array(String), 
	aliases: Array(IndexAlias), 
	aliases_version: VersionNumber, 
	version: VersionNumber, 
	mapping_version: VersionNumber, 
	settings_version: VersionNumber, 
	routing_num_shards: VersionNumber, 
	state: String, 
	settings: Dictionary(IndexName, IndexSettings), 
	in_sync_allocations: Dictionary(String, Array(String)), 
	primary_terms: Dictionary(String, integer), 
	mappings: Dictionary(String, TypeMapping), 
	rollover_info: Dictionary(String, RolloverConditions), 
	timestamp_range: Dictionary(String, UserDefinedValue), 
	system: Boolean
)

