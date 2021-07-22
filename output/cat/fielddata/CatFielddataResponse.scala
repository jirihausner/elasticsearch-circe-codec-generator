package com.converted.elasticsearch.cat.fielddata

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.fielddata.{ FielddataRecord }

@JsonCodec case class Response(
	body: Seq[FielddataRecord]
)
