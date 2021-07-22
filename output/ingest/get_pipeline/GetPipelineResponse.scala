package com.converted.elasticsearch.ingest.get_pipeline

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ingest._types.Pipeline.{ Pipeline }
import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }

@JsonCodec case class Response extends DictionaryResponseBase(String, Pipeline)

