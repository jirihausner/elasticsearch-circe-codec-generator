package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.Dictionary.{ Dictionary }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.analysis.StopWords.{ StopWords }
import com.converted.elasticsearch._types.common.{ Field, Fields, Id, IndexName, MinimumShouldMatch, Routing, ShapeRelation, Type, VersionNumber, VersionType }
import com.converted.elasticsearch._types.Geo.{ Distance }
import com.converted.elasticsearch._types.Numeric.{ double, integer, long }
import com.converted.elasticsearch._types.Scripting.{ Script }
import com.converted.elasticsearch._types.Time.{ DateMath, Time }
import com.converted.elasticsearch._types.query_dsl.{ FieldLookup, QueryBase, QueryContainer }
import com.converted.elasticsearch._types.query_dsl.{ GeoCoordinate, GeoShape }

@JsonCodec case class DistanceFeatureQuery(
	origin: Array[Double] | GeoCoordinate | DateMath, 
	pivot: Distance | Time, 
	field: Field
) extends QueryBase

@JsonCodec case class MoreLikeThisQuery(
	analyzer: String, 
	boost_terms: double, 
	fields: Fields, 
	include: Boolean, 
	like: Like | Array[Like], 
	max_doc_freq: integer, 
	max_query_terms: integer, 
	max_word_length: integer, 
	min_doc_freq: integer, 
	minimum_should_match: MinimumShouldMatch, 
	min_term_freq: integer, 
	min_word_length: integer, 
	per_field_analyzer: Dictionary[Field, String], 
	routing: Routing, 
	stop_words: StopWords, 
	unlike: Like | Array[Like], 
	version: VersionNumber, 
	version_type: VersionType
) extends QueryBase

@JsonCodec case class LikeDocument(
	doc: UserDefinedValue, 
	fields: Fields, 
	_id: Id | Double, 
	_type: Type, 
	_index: IndexName, 
	per_field_analyzer: Dictionary[Field, String], 
	routing: Routing
)
type Like = String | LikeDocument

@JsonCodec case class PercolateQuery(
	document: UserDefinedValue, 
	documents: Array[UserDefinedValue], 
	field: Field, 
	id: Id, 
	index: IndexName, 
	preference: String, 
	routing: Routing, 
	version: VersionNumber
) extends QueryBase

@JsonCodec case class PinnedQuery(
	ids: Array[Id] | Array[long], 
	organic: QueryContainer
) extends QueryBase

@JsonCodec sealed trait RankFeatureFunction

@JsonCodec case class RankFeatureQuery(
	function: RankFeatureFunction
) extends QueryBase

@JsonCodec case class ScriptQuery(
	script: Script
) extends QueryBase

@JsonCodec case class ScriptScoreQuery(
	query: QueryContainer, 
	script: Script
) extends QueryBase

@JsonCodec case class ShapeQuery(
	ignore_unmapped: Boolean, 
	indexed_shape: FieldLookup, 
	relation: ShapeRelation, 
	shape: GeoShape
) extends QueryBase
