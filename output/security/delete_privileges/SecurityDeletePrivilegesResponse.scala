package com.converted.elasticsearch.security.delete_privileges

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch.security.delete_privileges.{ FoundStatus }

@JsonCodec case class Response extends DictionaryResponseBase(String, Dictionary(String, FoundStatus))

