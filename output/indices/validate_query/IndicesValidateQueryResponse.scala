package com.converted.elasticsearch.indices.validate_query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.Stats.{ ShardStatistics }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		explanations: Seq[IndicesValidationExplanation], 
		_shards: ShardStatistics, 
		valid: Boolean, 
		error: String
	)
}


@JsonCodec case class IndicesValidationExplanation(
	error: String, 
	explanation: String, 
	index: IndexName, 
	valid: Boolean
)
