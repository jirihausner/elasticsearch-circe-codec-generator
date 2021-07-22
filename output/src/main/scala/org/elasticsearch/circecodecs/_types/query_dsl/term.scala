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
import org.elasticsearch.circecodecs._spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs._types.common.{ Field, Fuzziness, Id, IndexName, MultiTermQueryRewrite, Routing }
import org.elasticsearch.circecodecs._types.Numeric.{ double, float, integer, long }
import org.elasticsearch.circecodecs._types.Scripting.{ Script }
import org.elasticsearch.circecodecs._types.Time.{ DateMath }
import org.elasticsearch.circecodecs._types.query_dsl.{ QueryBase }

@JsonCodec case class ExistsQuery(
	field: Field
) extends QueryBase

@JsonCodec case class FuzzyQuery(
	max_expansions: integer, 
	prefix_length: integer, 
	rewrite: MultiTermQueryRewrite, 
	transpositions: Boolean, 
	fuzziness: Fuzziness, 
	value: UserDefinedValue
) extends QueryBase

@JsonCodec case class IdsQuery(
	values: Seq[Id] | Seq[long]
) extends QueryBase

@JsonCodec case class PrefixQuery(
	rewrite: MultiTermQueryRewrite, 
	value: String
) extends QueryBase

@JsonCodec case class RangeQuery(
	gt: double | DateMath, 
	gte: double | DateMath, 
	lt: double | DateMath, 
	lte: double | DateMath, 
	relation: RangeRelation, 
	time_zone: String, 
	from: double | DateMath, 
	to: double | DateMath
) extends QueryBase

object RangeRelation extends Enumeration {
	type RangeRelation = Value

	val within = Value(0, "within")
	val contains = Value(1, "contains")
	val intersects = Value(2, "intersects")
}

implicit val rangeRelationDecoder: Decoder[RangeRelation.Value] = Decoder.decodeEnumeration(RangeRelation)
implicit val rangeRelationEncoder: Encoder[RangeRelation.Value] = Decoder.encodeEnumeration(RangeRelation)

@JsonCodec case class RegexpQuery(
	flags: String, 
	max_determinized_states: integer, 
	value: String
) extends QueryBase

@JsonCodec case class TermQuery(
	value: String | float | Boolean
) extends QueryBase

@JsonCodec case class TermsQuery(
	terms: Seq[String], 
	index: IndexName, 
	id: Id, 
	path: String, 
	routing: Routing
) extends QueryBase

@JsonCodec case class TermsSetQuery(
	minimum_should_match_field: Field, 
	minimum_should_match_script: Script, 
	terms: Seq[String]
) extends QueryBase

@JsonCodec case class TypeQuery(
	value: String
) extends QueryBase

@JsonCodec case class WildcardQuery(
	rewrite: MultiTermQueryRewrite, 
	value: String
) extends QueryBase
