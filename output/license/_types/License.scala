package com.converted.elasticsearch.license._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._types.Time.{ EpochMillis }

object LicenseType extends Enumeration {
	type LicenseType = Value

val missing = Value(0, "missing")
val trial = Value(1, "trial")
val basic = Value(2, "basic")
val standard = Value(3, "standard")
val dev = Value(4, "dev")
val silver = Value(5, "silver")
val gold = Value(6, "gold")
val platinum = Value(7, "platinum")
val enterprise = Value(8, "enterprise")
}

implicit val licenseTypeDecoder: Decoder[LicenseType.Value] = Decoder.decodeEnumeration(LicenseType)
implicit val licenseTypeEncoder: Encoder[LicenseType.Value] = Decoder.encodeEnumeration(LicenseType)


object LicenseStatus extends Enumeration {
	type LicenseStatus = Value

val active = Value(0, "active")
val valid = Value(1, "valid")
val invalid = Value(2, "invalid")
val expired = Value(3, "expired")
}

implicit val licenseStatusDecoder: Decoder[LicenseStatus.Value] = Decoder.decodeEnumeration(LicenseStatus)
implicit val licenseStatusEncoder: Encoder[LicenseStatus.Value] = Decoder.encodeEnumeration(LicenseStatus)


@JsonCodec case class License(
	expiry_date_in_millis: EpochMillis, 
	issue_date_in_millis: EpochMillis, 
	issued_to: String, 
	issuer: String, 
	max_nodes: long, 
	max_resource_units: long, 
	signature: String, 
	start_date_in_millis: EpochMillis, 
	`type`: LicenseType, 
	uid: String
)

