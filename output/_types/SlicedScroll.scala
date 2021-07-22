package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.{ Field }
import com.converted.elasticsearch._types.{ integer }

@JsonCodec case class SlicedScroll(
	field: Field, 
	id: integer, 
	max: integer
)
