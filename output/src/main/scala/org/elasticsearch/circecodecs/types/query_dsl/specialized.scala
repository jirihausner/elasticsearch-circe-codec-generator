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
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.analysis.StopWords.{ StopWords }
import org.elasticsearch.circecodecs.types.common.{ Field, Fields, Id, IndexName, MinimumShouldMatch, Routing, ShapeRelation, Type, VersionNumber, VersionType }
import org.elasticsearch.circecodecs.types.Geo.{ Distance }
import org.elasticsearch.circecodecs.types.Numeric.{ double, integer, long }
import org.elasticsearch.circecodecs.types.Scripting.{ Script }
import org.elasticsearch.circecodecs.types.Time.{ DateMath, Time }
import org.elasticsearch.circecodecs.types.query_dsl.{ FieldLookup, QueryBase, QueryContainer }
import org.elasticsearch.circecodecs.types.query_dsl.{ GeoCoordinate, GeoShape }

@JsonCodec case class DistanceFeatureQuery(
	origin: Seq[Double] | GeoCoordinate | DateMath, 
	pivot: Distance | Time, 
	field: Field
) extends QueryBase

@JsonCodec case class MoreLikeThisQuery(
	analyzer: String, 
	boost_terms: double, 
	fields: Fields, 
	include: Boolean, 
	like: Like | Seq[Like], 
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
	unlike: Like | Seq[Like], 
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
	documents: Seq[UserDefinedValue], 
	field: Field, 
	id: Id, 
	index: IndexName, 
	preference: String, 
	routing: Routing, 
	version: VersionNumber
) extends QueryBase

@JsonCodec case class PinnedQuery(
	ids: Seq[Id] | Seq[long], 
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
