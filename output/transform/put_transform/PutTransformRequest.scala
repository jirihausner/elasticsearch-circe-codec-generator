package com.converted.elasticsearch.transform.put_transform

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._transform.preview_transform.PreviewTransformRequest.{ Request as PreviewTransformRequest }
import com.converted.elasticsearch._types.common.{ Id }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters
) extends PreviewTransformRequest

object Request {
	@JsonCodec case class PathParts(
		transform_id: Id
	)
	@JsonCodec case class QueryParameters(
		defer_validation: Boolean
	)
}

