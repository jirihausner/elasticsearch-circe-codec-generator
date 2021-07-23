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

package org.elasticsearch.circecodecs.cluster.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.indices.rollover.types.{ RolloverConditions }
import org.elasticsearch.circecodecs.indices.types.IndexSettings.{ IndexSettings }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ IndexAlias, IndexName, VersionNumber }
import org.elasticsearch.circecodecs.types.mapping.TypeMapping.{ TypeMapping }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }

@JsonCodec case class ClusterStateBlockIndex(
	description: String, 
	retryable: Boolean, 
	levels: Seq[String], 
	aliases: Seq[IndexAlias], 
	aliases_version: VersionNumber, 
	version: VersionNumber, 
	mapping_version: VersionNumber, 
	settings_version: VersionNumber, 
	routing_num_shards: VersionNumber, 
	state: String, 
	settings: Dictionary[IndexName, IndexSettings], 
	in_sync_allocations: Dictionary[String, Seq[String]], 
	primary_terms: Dictionary[String, integer], 
	mappings: Dictionary[String, TypeMapping], 
	rollover_info: Dictionary[String, RolloverConditions], 
	timestamp_range: Dictionary[String, UserDefinedValue], 
	system: Boolean
)
