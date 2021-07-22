package com.converted.elasticsearch.security.get_service_accounts

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Base.{ DictionaryResponseBase }
import com.converted.elasticsearch.security.get_service_accounts.{ RoleDescriptorWrapper }

@JsonCodec case class Response extends DictionaryResponseBase(String, RoleDescriptorWrapper)

