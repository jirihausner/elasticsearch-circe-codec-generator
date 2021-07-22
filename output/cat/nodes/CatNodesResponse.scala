package com.converted.elasticsearch.cat.nodes

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.nodes.{ NodesRecord }

@JsonCodec case class Response(
	body: Array(NodesRecord)
)

