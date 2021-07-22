package com.converted.elasticsearch.watcher._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ VersionNumber }
import com.converted.elasticsearch._types.Time.{ Timestamp }
import com.converted.elasticsearch.watcher._types.{ Actions }

@JsonCodec case class ActivationState(
	active: Boolean, 
	timestamp: Timestamp
)

@JsonCodec case class ActivationStatus(
	actions: Actions, 
	state: ActivationState, 
	version: VersionNumber
)
