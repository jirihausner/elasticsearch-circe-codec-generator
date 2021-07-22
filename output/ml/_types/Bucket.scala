package com.converted.elasticsearch.ml._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field, Id }
import com.converted.elasticsearch._types.Numeric.{ double, long }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class BucketSummary(
	anomaly_score: double, 
	bucket_influencers: Array(BucketInfluencer), 
	bucket_span: Time, 
	event_count: Long, 
	initial_anomaly_score: double, 
	is_interim: Boolean, 
	job_id: Id, 
	partition_scores: Array(PartitionScore), 
	processing_time_ms: double, 
	result_type: String, 
	timestamp: Time
)


@JsonCodec case class BucketInfluencer(
	bucket_span: Long, 
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
	bucket_span: Long, 
	is_interim: Boolean, 
	jobs: Array(OverallBucketJob), 
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

