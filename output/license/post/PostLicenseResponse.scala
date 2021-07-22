package com.converted.elasticsearch.license.post

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._license._types.License.{ LicenseStatus }
import com.converted.elasticsearch.license.post.{ Acknowledgement }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		acknowledge: Acknowledgement, 
		acknowledged: Boolean, 
		license_status: LicenseStatus
	)
}

