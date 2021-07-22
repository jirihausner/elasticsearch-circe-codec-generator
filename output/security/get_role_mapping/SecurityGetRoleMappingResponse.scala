package com.converted.elasticsearch.security.get_role_mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.RoleMapping.{ RoleMapping }
import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }

@JsonCodec case class Response extends DictionaryResponseBase(String, RoleMapping)

