package com.converted.elasticsearch.sql.query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		format: String
	)
	@JsonCodec case class Body(
		columnar: Boolean, 
		cursor: String, 
		fetch_size: integer, 
		filter: QueryContainer, 
		query: String, 
		request_timeout: Time, 
		page_timeout: Time, 
		time_zone: String, 
		field_multi_value_leniency: Boolean
	)
}

