package com.converted.elasticsearch.cat.datafeeds

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ml._types.Datafeed.{ DatafeedState }

@JsonCodec case class DatafeedsRecord(
	id: String, 
	state: DatafeedState, 
	assignment_explanation: String, 
	`buckets.count`: String, 
	`search.count`: String, 
	`search.time`: String, 
	`search.bucket_avg`: String, 
	`search.exp_avg_hour`: String, 
	`node.id`: String, 
	`node.name`: String, 
	`node.ephemeral_id`: String, 
	`node.address`: String
)
