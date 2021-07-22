package com.converted.elasticsearch.nodes.reload_secure_settings

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }
import com.converted.elasticsearch._types.common.{ NodeIds, Password }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class Request(
	path_parts: PathParts, 
	query_parameters: QueryParameters, 
	body: Body
) extends RequestBase

object Request {
	@JsonCodec case class PathParts(
		node_id: NodeIds
	)
	@JsonCodec case class QueryParameters(
		timeout: Time
	)
	@JsonCodec case class Body(
		secure_settings_password: Password
	)
}

