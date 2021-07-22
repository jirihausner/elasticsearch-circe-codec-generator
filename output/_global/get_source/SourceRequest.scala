package com.converted.elasticsearch._global.get_source

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.get_source.{ Request as GetRequest }

@JsonCodec case class Request extends GetRequest
