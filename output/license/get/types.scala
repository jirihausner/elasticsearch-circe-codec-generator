package com.converted.elasticsearch.license.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._license._types.License.{ LicenseStatus, LicenseType }
import com.converted.elasticsearch._types.common.{ Uuid }
import com.converted.elasticsearch._types.Numeric.{ integer, long }
import com.converted.elasticsearch._types.Time.{ DateString, EpochMillis }

@JsonCodec case class LicenseInformation(
	expiry_date: DateString, 
	expiry_date_in_millis: EpochMillis, 
	issue_date: DateString, 
	issue_date_in_millis: EpochMillis, 
	issued_to: String, 
	issuer: String, 
	max_nodes: Long, 
	max_resource_units: integer, 
	status: LicenseStatus, 
	`type`: LicenseType, 
	uid: Uuid, 
	start_date_in_millis: EpochMillis
)

