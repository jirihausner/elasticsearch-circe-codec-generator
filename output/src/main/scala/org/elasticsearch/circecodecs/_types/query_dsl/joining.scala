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

package org.elasticsearch.circecodecs._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._global.search._types.hits.{ InnerHits }
import org.elasticsearch.circecodecs._types.common.{ Field, Id, RelationName }
import org.elasticsearch.circecodecs._types.Numeric.{ integer }
import org.elasticsearch.circecodecs._types.query_dsl.{ QueryBase, QueryContainer }

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
