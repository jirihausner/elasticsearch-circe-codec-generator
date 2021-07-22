package com.converted.elasticsearch.security.get_builtin_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ RequestBase }

@JsonCodec case class Request extends RequestBase
