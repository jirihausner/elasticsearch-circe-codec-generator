package com.converted.elasticsearch._global.mtermvectors

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.termvectors.types.{ Filter, TermVector }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._types.common.{ Field, Fields, Id, IndexName, Routing, VersionNumber, VersionType }
import com.converted.elasticsearch._types.Numeric.{ long }

@JsonCodec case class Operation(
	doc: Any, 
	fields: Fields, 
	field_statistics: Boolean, 
	filter: Filter, 
	_id: Id, 
	_index: IndexName, 
	offsets: Boolean, 
	payloads: Boolean, 
	positions: Boolean, 
	routing: Routing, 
	term_statistics: Boolean, 
	version: VersionNumber, 
	version_type: VersionType
)


@JsonCodec case class TermVectorsResult(
	found: Boolean, 
	id: Id, 
	index: IndexName, 
	term_vectors: Dictionary(Field, TermVector), 
	took: Long, 
	version: VersionNumber
)

