package com.converted.elasticsearch.cat.node_attributes

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.node_attributes.{ NodeAttributesRecord }

@JsonCodec case class Response(
	body: Array(NodeAttributesRecord)
)

