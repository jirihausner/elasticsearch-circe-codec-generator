package com.converted.elasticsearch.eql.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._eql._types.EqlSearchResponseBase.{ EqlSearchResponseBase }

@JsonCodec case class Response[TEvent] extends EqlSearchResponseBase[TEvent]
