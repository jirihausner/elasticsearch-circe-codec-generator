package com.converted.elasticsearch.indices.update_aliases

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		master_timeout: Time, 
		timeout: Time
	)
	@JsonCodec case class Body(
		actions: Seq[IndicesUpdateAliasBulk]
	)
}


@JsonCodec sealed trait IndicesUpdateAliasBulk
