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

package org.elasticsearch.circecodecs.license._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.Numeric.{ long }
import org.elasticsearch.circecodecs._types.Time.{ EpochMillis }

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
