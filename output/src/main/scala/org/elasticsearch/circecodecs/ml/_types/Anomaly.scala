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

package org.elasticsearch.circecodecs.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.common.{ Field, Name }
import org.elasticsearch.circecodecs._types.Numeric.{ double, integer }
import org.elasticsearch.circecodecs._types.Time.{ EpochMillis, Time }

@JsonCodec case class Anomaly(
	actual: Seq[double], 
	bucket_span: Time, 
	by_field_name: String, 
	by_field_value: String, 
	causes: Seq[AnomalyCause], 
	detector_index: integer, 
	field_name: String, 
	function: String, 
	function_description: String, 
	influencers: Seq[Influence], 
	initial_record_score: double, 
	is_interim: Boolean, 
	job_id: String, 
	over_field_name: String, 
	over_field_value: String, 
	partition_field_name: String, 
	partition_field_value: String, 
	probability: double, 
	record_score: double, 
	result_type: String, 
	timestamp: EpochMillis, 
	typical: Seq[double]
)

@JsonCodec case class AnomalyCause(
	actual: Seq[double], 
	by_field_name: Name, 
	by_field_value: String, 
	correlated_by_field_value: String, 
	field_name: Field, 
	function: String, 
	function_description: String, 
	influencers: Seq[Influence], 
	over_field_name: Name, 
	over_field_value: String, 
	partition_field_name: String, 
	partition_field_value: String, 
	probability: double, 
	typical: Seq[double]
)

@JsonCodec case class Influence(
	influencer_field_name: String, 
	influencer_field_values: Seq[String]
)
