package com.converted.elasticsearch.ssl.get_certificates

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.ssl.get_certificates.{ CertificateInformation }

@JsonCodec case class Response(
	body: Array(CertificateInformation)
)

