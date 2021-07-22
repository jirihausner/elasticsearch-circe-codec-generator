package com.converted.elasticsearch.xpack.info

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.xpack.info.{ BuildInformation, Features, MinimalLicenseInformation }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		build: BuildInformation, 
		features: Features, 
		license: MinimalLicenseInformation, 
		tagline: String
	)
}

