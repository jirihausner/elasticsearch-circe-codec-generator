package com.converted.elasticsearch.nodes._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.nodes._types.{ NodeStatistics }

@JsonCodec case class NodesResponseBase(
	_nodes: NodeStatistics
)

