package com.converted.elasticsearch.cat.datafeeds

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.datafeeds.{ DatafeedsRecord }

@JsonCodec case class Response(
	body: Array(DatafeedsRecord)
)
