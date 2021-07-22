package com.converted.elasticsearch.eql.get_status

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.Time.{ EpochMillis }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		id: Id, 
		is_partial: Boolean, 
		is_running: Boolean, 
		start_time_in_millis: EpochMillis, 
		expiration_time_in_millis: EpochMillis, 
		completion_status: integer
	)
}

