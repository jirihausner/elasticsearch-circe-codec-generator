package com.converted.elasticsearch.cat.recovery

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.recovery.{ RecoveryRecord }

@JsonCodec case class Response(
	body: Array[RecoveryRecord]
)
