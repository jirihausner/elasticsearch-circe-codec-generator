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

package org.elasticsearch.circecodecs.transform._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs._types.aggregations.AggregationContainer.{ AggregationContainer }
import org.elasticsearch.circecodecs._types.aggregations.bucket.{ DateHistogramAggregation, GeoTileGridAggregation, HistogramAggregation, TermsAggregation }
import org.elasticsearch.circecodecs._types.common.{ Field, IndexName, Indices }
import org.elasticsearch.circecodecs._types.mapping.RuntimeFields.{ RuntimeFields }
import org.elasticsearch.circecodecs._types.Numeric.{ float, integer }
import org.elasticsearch.circecodecs._types.query_dsl.abstractions.{ QueryContainer }
import org.elasticsearch.circecodecs._types.Time.{ Time }

@JsonCodec case class Destination(
	index: IndexName, 
	pipeline: String
)

@JsonCodec case class Latest(
	sort: Field, 
	unique_key: Seq[Field]
)

@JsonCodec case class Pivot(
	aggregations: Dictionary[String, AggregationContainer], 
	group_by: Dictionary[String, PivotGroupByContainer], 
	max_page_search_size: integer
)

@JsonCodec case class PivotGroupByContainer(
	date_histogram: DateHistogramAggregation, 
	geotile_grid: GeoTileGridAggregation, 
	histogram: HistogramAggregation, 
	terms: TermsAggregation
)

@JsonCodec case class RetentionPolicyContainer(
	time: RetentionPolicy
)

@JsonCodec case class RetentionPolicy(
	field: Field, 
	max_age: Time
)

@JsonCodec case class Settings(
	dates_as_epoch_millis: Boolean, 
	docs_per_second: float, 
	max_page_search_size: integer
)

@JsonCodec case class Source(
	index: Indices, 
	query: QueryContainer, 
	runtime_mappings: RuntimeFields
)

@JsonCodec sealed trait Sync

@JsonCodec case class SyncContainer(
	time: TimeSync
)

@JsonCodec case class TimeSync(
	delay: Time, 
	field: Field
)
