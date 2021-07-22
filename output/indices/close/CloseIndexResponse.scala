package com.converted.elasticsearch.indices.close

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ AcknowledgedResponseBase }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch._types.Errors.{ ShardFailure }

@JsonCodec case class Response(
	body: Body
) extends AcknowledgedResponseBase

object Response {
	@JsonCodec case class Body(
		indices: Dictionary(IndexName, CloseIndexResult), 
		shards_acknowledged: Boolean
	)
}


@JsonCodec case class CloseIndexResult(
	closed: Boolean, 
	shards: Dictionary(String, CloseShardResult)
)


@JsonCodec case class CloseShardResult(
	failures: Array(ShardFailure)
)

