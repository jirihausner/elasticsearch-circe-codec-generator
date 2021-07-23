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

package org.elasticsearch.circecodecs.async_search.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.global.search.types.hits.{ HitsMetadata }
import org.elasticsearch.circecodecs.global.search.types.profile.{ Profile }
import org.elasticsearch.circecodecs.global.search.types.suggester.{ Suggest }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.aggregations.Aggregate.{ Aggregate }
import org.elasticsearch.circecodecs.types.common.{ Id, SuggestionName }
import org.elasticsearch.circecodecs.types.Numeric.{ double, long }
import org.elasticsearch.circecodecs.types.Stats.{ ClusterStatistics, ShardStatistics }

@JsonCodec case class AsyncSearch[TDocument](
	aggregations: Dictionary[String, Aggregate], 
	_clusters: ClusterStatistics, 
	fields: Dictionary[String, UserDefinedValue], 
	hits: HitsMetadata[TDocument], 
	max_score: double, 
	num_reduce_phases: long, 
	profile: Profile, 
	pit_id: Id, 
	_scroll_id: Id, 
	_shards: ShardStatistics, 
	suggest: Dictionary[SuggestionName, Seq[Suggest[TDocument]]], 
	terminated_early: Boolean, 
	timed_out: Boolean, 
	took: long
)
