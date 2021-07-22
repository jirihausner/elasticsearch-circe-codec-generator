package com.converted.elasticsearch._global.mget

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.SourceFilter.{ SourceFilter }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Fields, Id, IndexName, Routing, SequenceNumber, Type, VersionNumber, VersionType }
import com.converted.elasticsearch._types.Errors.{ MainError }
import com.converted.elasticsearch._types.Numeric.{ integer, long }

@JsonCodec case class Operation(
	_id: MultiGetId, 
	_index: IndexName, 
	routing: Routing, 
	_source: Boolean | Fields | SourceFilter, 
	stored_fields: Fields, 
	_type: Type, 
	version: VersionNumber, 
	version_type: VersionType
)

type MultiGetId = String | integer

@JsonCodec case class Hit[TDocument](
	error: MainError, 
	fields: Dictionary(String, UserDefinedValue), 
	found: Boolean, 
	_id: Id, 
	_index: IndexName, 
	_primary_term: long, 
	_routing: Routing, 
	_seq_no: SequenceNumber, 
	_source: TDocument, 
	_type: Type, 
	_version: VersionNumber
)

