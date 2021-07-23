/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.circecodecs.security.get_token

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.security.types.User.{ User }
import org.elasticsearch.circecodecs.types.common.{ Name }

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
