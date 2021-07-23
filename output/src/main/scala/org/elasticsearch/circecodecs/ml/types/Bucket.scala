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

package org.elasticsearch.circecodecs.ml.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.common.{ Field, Id }
import org.elasticsearch.circecodecs.types.Numeric.{ double, long }
import org.elasticsearch.circecodecs.types.Time.{ Time }

@JsonCodec case class BucketSummary(
	anomaly_score: double, 
	bucket_influencers: Seq[BucketInfluencer], 
	bucket_span: Time, 
	event_count: long, 
	initial_anomaly_score: double, 
	is_interim: Boolean, 
	job_id: Id, 
	partition_scores: Seq[PartitionScore], 
	processing_time_ms: double, 
	result_type: String, 
	timestamp: Time
)

@JsonCodec case class BucketInfluencer(
	bucket_span: long, 
	influencer_score: double, 
	influencer_field_name: Field, 
	influencer_field_value: String, 
	initial_influencer_score: double, 
	is_interim: Boolean, 
	job_id: Id, 
	probability: double, 
	result_type: String, 
	timestamp: Time, 
	foo: String
)

@JsonCodec case class OverallBucket(
	bucket_span: long, 
	is_interim: Boolean, 
	jobs: Seq[OverallBucketJob], 
	overall_score: double, 
	result_type: String, 
	timestamp: Time
)

@JsonCodec case class OverallBucketJob(
	job_id: Id, 
	max_anomaly_score: double
)

@JsonCodec case class PartitionScore(
	initial_record_score: double, 
	partition_field_name: Field, 
	partition_field_value: String, 
	probability: double, 
	record_score: double
)
