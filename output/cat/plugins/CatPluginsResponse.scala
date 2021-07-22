package com.converted.elasticsearch.cat.plugins

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.plugins.{ PluginsRecord }

@JsonCodec case class Response(
	body: Array[PluginsRecord]
)
