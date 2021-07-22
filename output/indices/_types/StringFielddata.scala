package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.indices._types.{ StringFielddataFormat }

@JsonCodec case class StringFielddata(
	format: StringFielddataFormat
)

