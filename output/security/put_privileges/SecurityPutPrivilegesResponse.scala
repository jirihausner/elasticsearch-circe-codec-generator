package com.converted.elasticsearch.security.put_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.CreatedStatus.{ CreatedStatus }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }

@JsonCodec case class Response extends DictionaryResponseBase[String, Dictionary[String, CreatedStatus]]
