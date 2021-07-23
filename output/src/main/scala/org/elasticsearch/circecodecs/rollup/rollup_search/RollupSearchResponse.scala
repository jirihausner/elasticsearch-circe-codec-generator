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

package org.elasticsearch.circecodecs.rollup.rollup_search

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.global.search.types.hits.{ HitsMetadata }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.aggregations.Aggregate.{ Aggregate }
import org.elasticsearch.circecodecs.types.common.{ AggregateName }
import org.elasticsearch.circecodecs.types.Numeric.{ long }
import org.elasticsearch.circecodecs.types.Stats.{ ShardStatistics }

@JsonCodec case class Response[TDocument](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		took: long, 
		timed_out: Boolean, 
		terminated_early: Boolean, 
		_shards: ShardStatistics, 
		hits: HitsMetadata[TDocument], 
		aggregations: Dictionary[AggregateName, Aggregate]
	)
}
