package com.converted.elasticsearch.indices.shard_stores

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch.indices.shard_stores.{ IndicesShardStores }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		indices: Dictionary[IndexName, IndicesShardStores]
	)
}

