package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.common.{ Field }
import com.converted.elasticsearch._types.Numeric.{ integer }
import com.converted.elasticsearch._types.query_dsl.{ NamedQuery, QueryBase, QueryContainer }

@JsonCodec case class SpanContainingQuery(
	big: SpanQuery, 
	little: SpanQuery
) extends QueryBase

@JsonCodec case class SpanFieldMaskingQuery(
	field: Field, 
	query: SpanQuery
) extends QueryBase

@JsonCodec case class SpanFirstQuery(
	end: integer, 
	`match`: SpanQuery
) extends QueryBase

@JsonCodec case class SpanGapQuery(
	field: Field, 
	width: integer
) extends QueryBase

@JsonCodec case class SpanMultiTermQuery(
	`match`: QueryContainer
) extends QueryBase

@JsonCodec case class SpanNearQuery(
	clauses: Array(SpanQuery), 
	in_order: Boolean, 
	slop: integer
) extends QueryBase

@JsonCodec case class SpanNotQuery(
	dist: integer, 
	exclude: SpanQuery, 
	include: SpanQuery, 
	post: integer, 
	pre: integer
) extends QueryBase

@JsonCodec case class SpanOrQuery(
	clauses: Array(SpanQuery)
) extends QueryBase

@JsonCodec case class SpanTermQuery(
	value: String
) extends QueryBase

@JsonCodec case class SpanWithinQuery(
	big: SpanQuery, 
	little: SpanQuery
) extends QueryBase

@JsonCodec case class SpanQuery(
	span_containing: NamedQuery(SpanContainingQuery | String), 
	field_masking_span: NamedQuery(SpanFieldMaskingQuery | String), 
	span_first: NamedQuery(SpanFirstQuery | String), 
	span_gap: NamedQuery(SpanGapQuery | integer), 
	span_multi: SpanMultiTermQuery, 
	span_near: NamedQuery(SpanNearQuery | String), 
	span_not: NamedQuery(SpanNotQuery | String), 
	span_or: NamedQuery(SpanOrQuery | String), 
	span_term: NamedQuery(SpanTermQuery | String), 
	span_within: NamedQuery(SpanWithinQuery | String)
) extends QueryBase

@JsonCodec case class SpanSubQuery extends QueryBase
