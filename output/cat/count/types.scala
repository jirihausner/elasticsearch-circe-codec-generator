package com.converted.elasticsearch.cat.count

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Time.{ DateString, EpochMillis }

@JsonCodec case class CountRecord(
	epoch: EpochMillis, 
	timestamp: DateString, 
	count: String
)

