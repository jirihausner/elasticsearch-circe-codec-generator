package com.converted.elasticsearch.indices.get_settings

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.IndexState.{ IndexState }
import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch._types.common.{ IndexName }

@JsonCodec case class Response extends DictionaryResponseBase(IndexName, IndexState)

