package com.converted.elasticsearch.security.grant_api_key

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Name }
import com.converted.elasticsearch._types.Time.{ Time }

@JsonCodec case class ApiKey(
	name: Name, 
	expiration: Time, 
	role_descriptors: Array(Dictionary(String, UserDefinedValue))
)

object ApiKeyGrantType extends Enumeration {
	type ApiKeyGrantType = Value

	val access_token = Value(0, "access_token")
	val password = Value(1, "password")
}

implicit val apiKeyGrantTypeDecoder: Decoder[ApiKeyGrantType.Value] = Decoder.decodeEnumeration(ApiKeyGrantType)
implicit val apiKeyGrantTypeEncoder: Encoder[ApiKeyGrantType.Value] = Decoder.encodeEnumeration(ApiKeyGrantType)
