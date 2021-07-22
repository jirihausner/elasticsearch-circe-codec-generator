package com.converted.elasticsearch._global.search_shards

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ IndexName, Name }
import com.converted.elasticsearch._types.Node.{ NodeAttributes, NodeShard }
import com.converted.elasticsearch._types.query_dsl.abstractions.{ QueryContainer }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		nodes: Dictionary[String, NodeAttributes], 
		shards: Seq[Seq[NodeShard]], 
		indices: Dictionary[IndexName, ShardStoreIndex]
	)
}


@JsonCodec case class ShardStoreIndex(
	aliases: Seq[Name], 
	filter: QueryContainer
)
