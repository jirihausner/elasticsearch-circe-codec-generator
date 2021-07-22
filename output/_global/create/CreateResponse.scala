package com.converted.elasticsearch._global.create

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ WriteResponseBase }

@JsonCodec case class Response extends WriteResponseBase

