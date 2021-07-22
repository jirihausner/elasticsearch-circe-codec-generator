package com.converted.elasticsearch.ml.preview_data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		feature_values: Array[Dictionary[Field, String]]
	)
}

