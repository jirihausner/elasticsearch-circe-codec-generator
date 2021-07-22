package com.converted.elasticsearch.ssl.get_certificates

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class CertificateInformation(
	alias: String, 
	expiry: DateString, 
	format: String, 
	has_private_key: Boolean, 
	path: String, 
	serial_number: String, 
	subject_dn: String
)

