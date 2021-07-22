package com.converted.elasticsearch._global.termvectors

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field, Id, IndexName, Type, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ long }
import com.converted.elasticsearch._global.termvectors.{ TermVector }

@JsonCodec case class Response(
	body: Body
)

object Response {
	@JsonCodec case class Body(
		found: Boolean, 
		_id: Id, 
		_index: IndexName, 
		term_vectors: Dictionary[Field, TermVector], 
		took: long, 
		_type: Type, 
		_version: VersionNumber
	)
}

