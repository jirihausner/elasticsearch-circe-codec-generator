package com.converted.elasticsearch.cluster.allocation_explain

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Request(
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		include_disk_info: Boolean, 
		include_yes_decisions: Boolean
	)
	@JsonCodec case class Body(
		current_node: String, 
		index: IndexName, 
		primary: Boolean, 
		shard: integer
	)
}

