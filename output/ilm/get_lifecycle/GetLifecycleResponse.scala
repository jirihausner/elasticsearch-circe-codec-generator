package com.converted.elasticsearch.ilm.get_lifecycle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch.ilm.get_lifecycle.{ Lifecycle }

@JsonCodec case class Response extends DictionaryResponseBase[String, Lifecycle]
