package com.converted.elasticsearch.cat.shards

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.shards.{ ShardsRecord }

@JsonCodec case class Response(
	body: Seq[ShardsRecord]
)
