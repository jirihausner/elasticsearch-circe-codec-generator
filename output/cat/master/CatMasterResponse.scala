package com.converted.elasticsearch.cat.master

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.master.{ MasterRecord }

@JsonCodec case class Response(
	body: Array(MasterRecord)
)

