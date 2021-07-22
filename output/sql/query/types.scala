package com.converted.elasticsearch.sql.query

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Name }

@JsonCodec case class Column(
	name: Name, 
	`type`: String
)
type Row = Array[UserDefinedValue]
