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

package org.elasticsearch.circecodecs.rollup.get_rollup_index_capabilities

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.common.{ Field, Id, IndexName }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec case class IndexCapabilities(
	rollup_jobs: Seq[RollupJobSummary]
)

@JsonCodec case class RollupJobSummary(
	fields: Dictionary[Field, Seq[RollupJobSummaryField]], 
	index_pattern: String, 
	job_id: Id, 
	rollup_index: IndexName
)

@JsonCodec case class RollupJobSummaryField(
	agg: String, 
	time_zone: String, 
	calendar_interval: Time
)
