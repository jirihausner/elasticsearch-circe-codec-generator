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

package org.elasticsearch.circecodecs._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs._types.query_dsl.geo.{ GeoLocation }
import org.elasticsearch.circecodecs._types.mapping.{ DocValuesPropertyBase }

@JsonCodec case class GeoPointProperty(
	ignore_malformed: Boolean, 
	ignore_z_value: Boolean, 
	null_value: GeoLocation, 
	`type`: "geo_point""
) extends DocValuesPropertyBase

object GeoOrientation extends Enumeration {
	type GeoOrientation = Value

	val right = Value(0, "right")
	val rIGHT = Value(1, "RIGHT")
	val counterclockwise = Value(2, "counterclockwise")
	val cOUNTERCLOCKWISE = Value(3, "COUNTERCLOCKWISE")
	val ccw = Value(4, "ccw")
	val cCW = Value(5, "CCW")
	val left = Value(6, "left")
	val lEFT = Value(7, "LEFT")
	val clockwise = Value(8, "clockwise")
	val cLOCKWISE = Value(9, "CLOCKWISE")
	val cw = Value(10, "cw")
	val cW = Value(11, "CW")
}

implicit val geoOrientationDecoder: Decoder[GeoOrientation.Value] = Decoder.decodeEnumeration(GeoOrientation)
implicit val geoOrientationEncoder: Encoder[GeoOrientation.Value] = Decoder.encodeEnumeration(GeoOrientation)

@JsonCodec case class GeoShapeProperty(
	coerce: Boolean, 
	ignore_malformed: Boolean, 
	ignore_z_value: Boolean, 
	orientation: GeoOrientation, 
	strategy: GeoStrategy, 
	`type`: "geo_shape""
) extends DocValuesPropertyBase

object GeoStrategy extends Enumeration {
	type GeoStrategy = Value

	val recursive = Value(0, "recursive")
	val term = Value(1, "term")
}

implicit val geoStrategyDecoder: Decoder[GeoStrategy.Value] = Decoder.decodeEnumeration(GeoStrategy)
implicit val geoStrategyEncoder: Encoder[GeoStrategy.Value] = Decoder.encodeEnumeration(GeoStrategy)

object GeoTree extends Enumeration {
	type GeoTree = Value

	val geohash = Value(0, "geohash")
	val quadtree = Value(1, "quadtree")
}

implicit val geoTreeDecoder: Decoder[GeoTree.Value] = Decoder.decodeEnumeration(GeoTree)
implicit val geoTreeEncoder: Encoder[GeoTree.Value] = Decoder.encodeEnumeration(GeoTree)

@JsonCodec case class PointProperty(
	ignore_malformed: Boolean, 
	ignore_z_value: Boolean, 
	null_value: String, 
	`type`: "point""
) extends DocValuesPropertyBase
