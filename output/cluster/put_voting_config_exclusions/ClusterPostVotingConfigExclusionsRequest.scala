package com.converted.elasticsearch.cluster.put_voting_config_exclusions

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Ids, Names }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	query_parameters: QueryParameters
) extends RequestBase

object Request {
	@JsonCodec case class QueryParameters(
		node_names: Names, 
		node_ids: Ids, 
		timeout: Time, 
		wait_for_removal: Boolean
	)
}

