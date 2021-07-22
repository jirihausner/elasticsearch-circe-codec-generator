package com.converted.elasticsearch.cat.transforms

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.transforms.{ TransformsRecord }

@JsonCodec case class Response(
	body: Array[TransformsRecord]
)
