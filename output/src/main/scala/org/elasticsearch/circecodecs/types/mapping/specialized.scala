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

package org.elasticsearch.circecodecs.types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.indices.types.StringFielddata.{ StringFielddata }
import org.elasticsearch.circecodecs.spec_utils.UserDefinedValue.{ UserDefinedValue }
import org.elasticsearch.circecodecs.types.common.{ Field, Name }
import org.elasticsearch.circecodecs.types.Numeric.{ double, integer }
import org.elasticsearch.circecodecs.types.mapping.{ DocValuesPropertyBase, IndexOptions }
import org.elasticsearch.circecodecs.types.mapping.{ PropertyBase }
import org.elasticsearch.circecodecs.types.mapping.{ TermVectorOption }

@JsonCodec case class CompletionProperty(
	analyzer: String, 
	contexts: Seq[SuggestContext], 
	max_input_length: integer, 
	preserve_position_increments: Boolean, 
	preserve_separators: Boolean, 
	search_analyzer: String, 
	`type`: "completion""
) extends DocValuesPropertyBase

@JsonCodec case class SuggestContext(
	name: Name, 
	path: Field, 
	`type`: String, 
	precision: integer
)

@JsonCodec case class ConstantKeywordProperty(
	value: UserDefinedValue, 
	`type`: "constant_keyword""
) extends PropertyBase

@JsonCodec case class FieldAliasProperty(
	path: Field, 
	`type`: "alias""
) extends PropertyBase

@JsonCodec case class GenericProperty(
	analyzer: String, 
	boost: double, 
	fielddata: StringFielddata, 
	ignore_malformed: Boolean, 
	index: Boolean, 
	index_options: IndexOptions, 
	norms: Boolean, 
	null_value: String, 
	position_increment_gap: integer, 
	search_analyzer: String, 
	term_vector: TermVectorOption, 
	`type`: String
) extends DocValuesPropertyBase

@JsonCodec case class HistogramProperty(
	ignore_malformed: Boolean, 
	`type`: "histogram""
) extends PropertyBase

@JsonCodec case class IpProperty(
	boost: double, 
	index: Boolean, 
	null_value: String, 
	`type`: "ip""
) extends DocValuesPropertyBase

@JsonCodec case class Murmur3HashProperty(
	`type`: "murmur3""
) extends DocValuesPropertyBase

object ShapeOrientation extends Enumeration {
	type ShapeOrientation = Value

	val right = Value(0, "right")
	val counterclockwise = Value(1, "counterclockwise")
	val ccw = Value(2, "ccw")
	val left = Value(3, "left")
	val clockwise = Value(4, "clockwise")
	val cw = Value(5, "cw")
}

implicit val shapeOrientationDecoder: Decoder[ShapeOrientation.Value] = Decoder.decodeEnumeration(ShapeOrientation)
implicit val shapeOrientationEncoder: Encoder[ShapeOrientation.Value] = Decoder.encodeEnumeration(ShapeOrientation)

@JsonCodec case class ShapeProperty(
	coerce: Boolean, 
	ignore_malformed: Boolean, 
	ignore_z_value: Boolean, 
	orientation: ShapeOrientation, 
	`type`: "shape""
) extends DocValuesPropertyBase

@JsonCodec case class TokenCountProperty(
	analyzer: String, 
	boost: double, 
	index: Boolean, 
	null_value: double, 
	enable_position_increments: Boolean, 
	`type`: "token_count""
) extends DocValuesPropertyBase
