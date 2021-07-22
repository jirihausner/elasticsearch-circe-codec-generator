package com.converted.elasticsearch.async_search.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._async_search._types.AsyncSearchResponseBase.{ AsyncSearchDocumentResponseBase }

@JsonCodec case class Response[TDocument] extends AsyncSearchDocumentResponseBase(TDocument)
