package com.converted.elasticsearch.cat.allocation

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.cat.allocation.{ AllocationRecord }

@JsonCodec case class Response(
	body: Array(AllocationRecord)
)

