package com.converted.elasticsearch.ml.post_job_data

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ integer, long }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		bucket_count: long, 
		earliest_record_timestamp: integer, 
		empty_bucket_count: long, 
		input_bytes: long, 
		input_field_count: long, 
		input_record_count: long, 
		invalid_date_count: long, 
		job_id: Id, 
		last_data_time: integer, 
		latest_record_timestamp: integer, 
		missing_field_count: long, 
		out_of_order_timestamp_count: long, 
		processed_field_count: long, 
		processed_record_count: long, 
		sparse_bucket_count: long
	)
}

