package com.converted.elasticsearch.license.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.license.get.{ LicenseInformation }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		license: LicenseInformation
	)
}

