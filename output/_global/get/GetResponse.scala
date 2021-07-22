package com.converted.elasticsearch._global.get

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Id, IndexName, SequenceNumber, Type, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Response[TDocument](
	body: Body
)

object Response {
	@JsonCodec case class Body(
		_index: IndexName, 
		fields: Dictionary(String, UserDefinedValue), 
		found: Boolean, 
		_id: Id, 
		_primary_term: Long, 
		_routing: String, 
		_seq_no: SequenceNumber, 
		_source: TDocument, 
		_type: Type, 
		_version: VersionNumber
	)
}

