package com.converted.elasticsearch.transform.preview_transform

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.IndexState.{ IndexState }

@JsonCodec case class Response[TTransform](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		generated_dest_index: IndexState, 
		preview: Array(TTransform)
	)
}

