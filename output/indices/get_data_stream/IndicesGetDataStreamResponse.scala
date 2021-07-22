package com.converted.elasticsearch.indices.get_data_stream

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.DataStreamStatus.{ DataStreamHealthStatus }
import com.converted.elasticsearch._types.common.{ DataStreamName, Field, IndexName, Metadata, Name, Uuid }
import com.converted.elasticsearch._types.Numeric.{ integer }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		data_streams: Array(IndicesGetDataStreamItem)
	)
}


@JsonCodec case class IndicesGetDataStreamItem(
	name: DataStreamName, 
	timestamp_field: IndicesGetDataStreamItemTimestampField, 
	indices: Array(IndicesGetDataStreamItemIndex), 
	generation: integer, 
	template: Name, 
	hidden: Boolean, 
	system: Boolean, 
	status: DataStreamHealthStatus, 
	ilm_policy: Name, 
	_meta: Metadata
)


@JsonCodec case class IndicesGetDataStreamItemTimestampField(
	name: Field
)


@JsonCodec case class IndicesGetDataStreamItemIndex(
	index_name: IndexName, 
	index_uuid: Uuid
)

