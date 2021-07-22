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
		bucket_count: Long, 
		earliest_record_timestamp: integer, 
		empty_bucket_count: Long, 
		input_bytes: Long, 
		input_field_count: Long, 
		input_record_count: Long, 
		invalid_date_count: Long, 
		job_id: Id, 
		last_data_time: integer, 
		latest_record_timestamp: integer, 
		missing_field_count: Long, 
		out_of_order_timestamp_count: Long, 
		processed_field_count: Long, 
		processed_record_count: Long, 
		sparse_bucket_count: Long
	)
}

