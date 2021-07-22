package com.converted.elasticsearch._global.search._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.explain.types.{ Explanation }
import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Field, Fields, Id, IndexName, Name, SequenceNumber, Type, VersionNumber }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.Scripting.{ ScriptField }
import com.converted.elasticsearch._global.search._types.{ FieldCollapse }
import com.converted.elasticsearch._global.search._types.{ Highlight }
import com.converted.elasticsearch._global.search._types.{ Sort, SortResults }
import com.converted.elasticsearch._global.search._types.{ SourceFilter }

@JsonCodec case class Hit[TDocument](
	_index: IndexName, 
	_id: Id, 
	_score: double, 
	_type: Type, 
	_explanation: Explanation, 
	fields: Dictionary[String, UserDefinedValue], 
	highlight: Dictionary[String, Array[String]], 
	inner_hits: Dictionary[String, InnerHitsResult], 
	matched_queries: Array[String], 
	_nested: NestedIdentity, 
	_ignored: Array[String], 
	_shard: String, 
	_node: String, 
	_routing: String, 
	_source: TDocument, 
	_seq_no: SequenceNumber, 
	_primary_term: long, 
	_version: VersionNumber, 
	sort: SortResults
)

@JsonCodec case class HitsMetadata[T](
	total: TotalHits | long, 
	hits: Array[Hit[T]], 
	max_score: double
)

@JsonCodec case class HitMetadata[TDocument](
	_id: Id, 
	_index: IndexName, 
	_primary_term: long, 
	_routing: String, 
	_seq_no: SequenceNumber, 
	_source: TDocument, 
	_type: Type, 
	_version: VersionNumber
)

@JsonCodec case class InnerHitsMetadata(
	total: TotalHits | long, 
	hits: Array[Hit[Dictionary[String, UserDefinedValue]]], 
	max_score: double
)

@JsonCodec case class InnerHitsResult(
	hits: InnerHitsMetadata
)

@JsonCodec case class NestedIdentity(
	field: Field, 
	offset: integer, 
	_nested: NestedIdentity
)

@JsonCodec case class TotalHits(
	relation: TotalHitsRelation, 
	value: long
)

object TotalHitsRelation extends Enumeration {
	type TotalHitsRelation = Value

	val eq = Value(0, "eq")
	val gte = Value(1, "gte")
}

implicit val totalHitsRelationDecoder: Decoder[TotalHitsRelation.Value] = Decoder.decodeEnumeration(TotalHitsRelation)
implicit val totalHitsRelationEncoder: Encoder[TotalHitsRelation.Value] = Decoder.encodeEnumeration(TotalHitsRelation)

@JsonCodec case class InnerHits(
	name: Name, 
	size: integer, 
	from: integer, 
	collapse: FieldCollapse, 
	docvalue_fields: Fields, 
	explain: Boolean, 
	highlight: Highlight, 
	ignore_unmapped: Boolean, 
	script_fields: Dictionary[String, ScriptField], 
	seq_no_primary_term: Boolean, 
	fields: Fields, 
	sort: Sort, 
	_source: Boolean | SourceFilter, 
	version: Boolean
)
