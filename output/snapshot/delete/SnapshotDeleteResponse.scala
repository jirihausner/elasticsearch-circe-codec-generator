package com.converted.elasticsearch.snapshot.delete

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ AcknowledgedResponseBase }

@JsonCodec case class Response extends AcknowledgedResponseBase
