package com.converted.elasticsearch._global.scroll

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search.SearchResponse.{ Response as SearchResponse }

@JsonCodec case class Response[TDocument] extends SearchResponse(TDocument)

