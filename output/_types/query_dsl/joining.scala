package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._global.search._types.hits.{ InnerHits }
import com.converted.elasticsearch._types.common.{ Field, Id, RelationName }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.{ QueryBase, QueryContainer }

object ChildScoreMode extends Enumeration {
	type ChildScoreMode = Value

	val none = Value(0, "none")
	val avg = Value(1, "avg")
	val sum = Value(2, "sum")
	val max = Value(3, "max")
	val min = Value(4, "min")
}

implicit val childScoreModeDecoder: Decoder[ChildScoreMode.Value] = Decoder.decodeEnumeration(ChildScoreMode)
implicit val childScoreModeEncoder: Encoder[ChildScoreMode.Value] = Decoder.encodeEnumeration(ChildScoreMode)

@JsonCodec case class HasChildQuery(
	ignore_unmapped: Boolean, 
	inner_hits: InnerHits, 
	max_children: integer, 
	min_children: integer, 
	query: QueryContainer, 
	score_mode: ChildScoreMode, 
	`type`: RelationName
) extends QueryBase

@JsonCodec case class HasParentQuery(
	ignore_unmapped: Boolean, 
	inner_hits: InnerHits, 
	parent_type: RelationName, 
	query: QueryContainer, 
	score: Boolean
) extends QueryBase

@JsonCodec case class NestedQuery(
	ignore_unmapped: Boolean, 
	inner_hits: InnerHits, 
	path: Field, 
	query: QueryContainer, 
	score_mode: NestedScoreMode
) extends QueryBase

object NestedScoreMode extends Enumeration {
	type NestedScoreMode = Value

	val avg = Value(0, "avg")
	val sum = Value(1, "sum")
	val min = Value(2, "min")
	val max = Value(3, "max")
	val none = Value(4, "none")
}

implicit val nestedScoreModeDecoder: Decoder[NestedScoreMode.Value] = Decoder.decodeEnumeration(NestedScoreMode)
implicit val nestedScoreModeEncoder: Encoder[NestedScoreMode.Value] = Decoder.encodeEnumeration(NestedScoreMode)

@JsonCodec case class ParentIdQuery(
	id: Id, 
	ignore_unmapped: Boolean, 
	`type`: RelationName
) extends QueryBase
