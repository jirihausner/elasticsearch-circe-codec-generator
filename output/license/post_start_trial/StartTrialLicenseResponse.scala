package com.converted.elasticsearch.license.post_start_trial

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._license._types.License.{ LicenseType }
import com.converted.elasticsearch._types.Base.{ AcknowledgedResponseBase }

@JsonCodec case class Response(
	body: Body
) extends AcknowledgedResponseBase

object Response {
	@JsonCodec case class Body(
		error_message: String, 
		acknowledged: Boolean, 
		trial_was_started: Boolean, 
		`type`: LicenseType
	)
}

