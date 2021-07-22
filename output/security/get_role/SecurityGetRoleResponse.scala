package com.converted.elasticsearch.security.get_role

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch.security.get_role.{ Role }

@JsonCodec case class Response extends DictionaryResponseBase[String, Role]
