package com.converted.elasticsearch.indices.put_mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ IndicesResponseBase }

@JsonCodec case class Response extends IndicesResponseBase
