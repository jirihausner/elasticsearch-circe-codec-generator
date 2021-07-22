package com.converted.elasticsearch.security.get_token

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.User.{ User }
import com.converted.elasticsearch._types.common.{ Name }

object AccessTokenGrantType extends Enumeration {
	type AccessTokenGrantType = Value

	val password = Value(0, "password")
	val client_credentials = Value(1, "client_credentials")
	val _kerberos = Value(2, "_kerberos")
	val refresh_token = Value(3, "refresh_token")
}

implicit val accessTokenGrantTypeDecoder: Decoder[AccessTokenGrantType.Value] = Decoder.decodeEnumeration(AccessTokenGrantType)
implicit val accessTokenGrantTypeEncoder: Encoder[AccessTokenGrantType.Value] = Decoder.encodeEnumeration(AccessTokenGrantType)

@JsonCodec case class UserRealm(
	name: Name, 
	`type`: String
)

@JsonCodec case class AuthenticationProvider(
	`type`: String, 
	name: Name
)

@JsonCodec case class AuthenticatedUser(
	authentication_realm: UserRealm, 
	lookup_realm: UserRealm, 
	authentication_provider: AuthenticationProvider, 
	authentication_type: String
) extends User
