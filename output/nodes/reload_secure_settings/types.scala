package com.converted.elasticsearch.nodes.reload_secure_settings

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class NodeReloadException(
	name: Name, 
	reload_exception: NodeReloadExceptionCausedBy
)


@JsonCodec case class NodeReloadExceptionCausedBy(
	`type`: String, 
	reason: String, 
	caused_by: NodeReloadExceptionCausedBy
)

