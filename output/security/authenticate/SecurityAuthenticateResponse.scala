package com.converted.elasticsearch.security.authenticate

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._security._types.RealmInfo.{ RealmInfo }
import com.converted.elasticsearch._types.common.{ Metadata, Name, Username }
import com.converted.elasticsearch.security.authenticate.{ Token }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		authentication_realm: RealmInfo, 
		email: String, 
		full_name: Name, 
		lookup_realm: RealmInfo, 
		metadata: Metadata, 
		roles: Seq[String], 
		username: Username, 
		enabled: Boolean, 
		authentication_type: String, 
		token: Token
	)
}

