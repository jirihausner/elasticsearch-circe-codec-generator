package com.converted.elasticsearch.indices.resolve_index

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ DataStreamName, Field, Indices, Name }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		indices: Array(ResolveIndexItem), 
		aliases: Array(ResolveIndexAliasItem), 
		data_streams: Array(ResolveIndexDataStreamsItem)
	)
}


@JsonCodec case class ResolveIndexItem(
	name: Name, 
	aliases: Array(String), 
	attributes: Array(String), 
	data_stream: DataStreamName
)


@JsonCodec case class ResolveIndexAliasItem(
	name: Name, 
	indices: Indices
)


@JsonCodec case class ResolveIndexDataStreamsItem(
	name: DataStreamName, 
	timestamp_field: Field, 
	backing_indices: Indices
)

