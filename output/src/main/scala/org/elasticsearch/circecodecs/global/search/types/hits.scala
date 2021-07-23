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

package org.elasticsearch.circecodecs.global.search.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.global.explain.types.{ Explanation }
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ Field, Fields, Id, IndexName, Name, SequenceNumber, Type, VersionNumber }
import org.elasticsearch.circecodecs.types.Numeric.{ double, integer, long }
import org.elasticsearch.circecodecs.types.Scripting.{ ScriptField }
import org.elasticsearch.circecodecs.global.search.types.{ FieldCollapse }
import org.elasticsearch.circecodecs.global.search.types.{ Highlight }
import org.elasticsearch.circecodecs.global.search.types.{ Sort, SortResults }
import org.elasticsearch.circecodecs.global.search.types.{ SourceFilter }

@JsonCodec case class Hit[TDocument](
	_index: IndexName, 
	_id: Id, 
	_score: double, 
	_type: Type, 
	_explanation: Explanation, 
	fields: Dictionary[String, UserDefinedValue], 
	highlight: Dictionary[String, Seq[String]], 
	inner_hits: Dictionary[String, InnerHitsResult], 
	matched_queries: Seq[String], 
	_nested: NestedIdentity, 
	_ignored: Seq[String], 
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
	hits: Seq[Hit[T]], 
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
	hits: Seq[Hit[Dictionary[String, UserDefinedValue]]], 
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
