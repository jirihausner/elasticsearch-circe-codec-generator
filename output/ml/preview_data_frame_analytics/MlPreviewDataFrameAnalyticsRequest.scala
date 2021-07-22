package com.converted.elasticsearch.ml.preview_data_frame_analytics

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ Id }
import com.converted.elasticsearch.ml.preview_data_frame_analytics.{ DataframePreviewConfig }

@JsonCodec case class Request(
	path_parts: PathParts, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		id: Id
	)
	@JsonCodec case class Body(
		config: DataframePreviewConfig
	)
}

