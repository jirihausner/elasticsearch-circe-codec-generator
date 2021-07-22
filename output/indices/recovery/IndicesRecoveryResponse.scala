package com.converted.elasticsearch.indices.recovery

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch._types.common.{ IndexName }
import com.converted.elasticsearch.indices.recovery.{ RecoveryStatus }

@JsonCodec case class Response extends DictionaryResponseBase[IndexName, RecoveryStatus]
