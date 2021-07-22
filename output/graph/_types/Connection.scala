package com.converted.elasticsearch.graph._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.Numeric.{ double, long }

@JsonCodec case class Connection(
	doc_count: long, 
	source: long, 
	target: long, 
	weight: double
)
