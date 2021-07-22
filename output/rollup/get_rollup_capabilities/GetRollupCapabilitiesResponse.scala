package com.converted.elasticsearch.rollup.get_rollup_capabilities

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch.rollup.get_rollup_capabilities.{ RollupCapabilities }

@JsonCodec case class Response extends DictionaryResponseBase(IndexName, RollupCapabilities)
