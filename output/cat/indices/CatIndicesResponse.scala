package com.converted.elasticsearch.cat.indices

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.indices.{ IndicesRecord }

@JsonCodec case class Response(
	body: Seq[IndicesRecord]
)
