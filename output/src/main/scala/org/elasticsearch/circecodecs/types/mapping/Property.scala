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
import org.elasticsearch.circecodecs.spec_utils.Dictionary.{ Dictionary }
import org.elasticsearch.circecodecs.types.common.{ Metadata, PropertyName }
import org.elasticsearch.circecodecs.types.Numeric.{ integer }
import org.elasticsearch.circecodecs.types.mapping.{ FlattenedProperty }
import org.elasticsearch.circecodecs.types.mapping.{ CoreProperty, JoinProperty, PercolatorProperty, RankFeatureProperty, RankFeaturesProperty }
import org.elasticsearch.circecodecs.types.mapping.{ DynamicMapping }
import org.elasticsearch.circecodecs.types.mapping.{ ConstantKeywordProperty, FieldAliasProperty, HistogramProperty }

@JsonCodec case class PropertyBase(
	local_metadata: Metadata, 
	meta: Dictionary[String, String], 
	name: PropertyName, 
	properties: Dictionary[PropertyName, Property], 
	ignore_above: integer, 
	dynamic: Boolean | DynamicMapping, 
	fields: Dictionary[PropertyName, Property]
)
type Property = FlattenedProperty | JoinProperty | PercolatorProperty | RankFeatureProperty | RankFeaturesProperty | ConstantKeywordProperty | FieldAliasProperty | HistogramProperty | CoreProperty

object FieldType extends Enumeration {
	type FieldType = Value

	val none = Value(0, "none")
	val geo_point = Value(1, "geo_point")
	val geo_shape = Value(2, "geo_shape")
	val ip = Value(3, "ip")
	val binary = Value(4, "binary")
	val keyword = Value(5, "keyword")
	val text = Value(6, "text")
	val search_as_you_type = Value(7, "search_as_you_type")
	val date = Value(8, "date")
	val date_nanos = Value(9, "date_nanos")
	val boolean = Value(10, "boolean")
	val completion = Value(11, "completion")
	val nested = Value(12, "nested")
	val object = Value(13, "object")
	val murmur3 = Value(14, "murmur3")
	val token_count = Value(15, "token_count")
	val percolator = Value(16, "percolator")
	val integer = Value(17, "integer")
	val long = Value(18, "long")
	val short = Value(19, "short")
	val byte = Value(20, "byte")
	val float = Value(21, "float")
	val half_float = Value(22, "half_float")
	val scaled_float = Value(23, "scaled_float")
	val double = Value(24, "double")
	val integer_range = Value(25, "integer_range")
	val float_range = Value(26, "float_range")
	val long_range = Value(27, "long_range")
	val double_range = Value(28, "double_range")
	val date_range = Value(29, "date_range")
	val ip_range = Value(30, "ip_range")
	val alias = Value(31, "alias")
	val join = Value(32, "join")
	val rank_feature = Value(33, "rank_feature")
	val rank_features = Value(34, "rank_features")
	val flattened = Value(35, "flattened")
	val shape = Value(36, "shape")
	val histogram = Value(37, "histogram")
	val constant_keyword = Value(38, "constant_keyword")
}

implicit val fieldTypeDecoder: Decoder[FieldType.Value] = Decoder.decodeEnumeration(FieldType)
implicit val fieldTypeEncoder: Encoder[FieldType.Value] = Decoder.encodeEnumeration(FieldType)

@JsonCodec sealed trait PropertyWithClrOrigin
