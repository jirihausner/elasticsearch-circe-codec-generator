package com.converted.elasticsearch.sql.translate

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
	)
	@JsonCodec case class Body(
		fetch_size: integer, 
		filter: QueryContainer, 
		query: String, 
		time_zone: String
	)
}

