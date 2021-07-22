package com.converted.elasticsearch.indices._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch.indices._types.{ FielddataFilter }
import com.converted.elasticsearch.indices._types.{ FielddataLoading }

@JsonCodec case class Fielddata(
	filter: FielddataFilter, 
	loading: FielddataLoading
)
