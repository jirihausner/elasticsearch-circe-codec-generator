package com.converted.elasticsearch.indices.forcemerge

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ ShardsOperationResponseBase }

@JsonCodec case class Response extends ShardsOperationResponseBase
