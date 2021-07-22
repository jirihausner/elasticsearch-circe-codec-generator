package com.converted.elasticsearch._global.field_caps

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field, Indices }
import com.converted.elasticsearch._global.field_caps.{ FieldCapability }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		indices: Indices, 
		fields: Dictionary(Field, Dictionary(String, FieldCapability))
	)
}

