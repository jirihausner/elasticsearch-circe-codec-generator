package com.converted.elasticsearch.ilm.get_lifecycle

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._ilm._types.Policy.{ Policy }
import com.converted.elasticsearch._types.common.{ VersionNumber }
import com.converted.elasticsearch._types.Time.{ DateString }

@JsonCodec case class Lifecycle(
	modified_date: DateString, 
	policy: Policy, 
	version: VersionNumber
)

