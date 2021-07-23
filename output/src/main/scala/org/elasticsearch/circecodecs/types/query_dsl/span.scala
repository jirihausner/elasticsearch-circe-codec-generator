/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.circecodecs.types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.common.{ Field }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }
import org.elasticsearch.circecodecs.types.query_dsl.{ NamedQuery, QueryBase, QueryContainer }

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
	clauses: Seq[SpanQuery], 
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
	clauses: Seq[SpanQuery]
) extends QueryBase

@JsonCodec case class SpanTermQuery(
	value: String
) extends QueryBase

@JsonCodec case class SpanWithinQuery(
	big: SpanQuery, 
	little: SpanQuery
) extends QueryBase

@JsonCodec case class SpanQuery(
	span_containing: NamedQuery[SpanContainingQuery | String], 
	field_masking_span: NamedQuery[SpanFieldMaskingQuery | String], 
	span_first: NamedQuery[SpanFirstQuery | String], 
	span_gap: NamedQuery[SpanGapQuery | integer], 
	span_multi: SpanMultiTermQuery, 
	span_near: NamedQuery[SpanNearQuery | String], 
	span_not: NamedQuery[SpanNotQuery | String], 
	span_or: NamedQuery[SpanOrQuery | String], 
	span_term: NamedQuery[SpanTermQuery | String], 
	span_within: NamedQuery[SpanWithinQuery | String]
) extends QueryBase

@JsonCodec case class SpanSubQuery extends QueryBase
