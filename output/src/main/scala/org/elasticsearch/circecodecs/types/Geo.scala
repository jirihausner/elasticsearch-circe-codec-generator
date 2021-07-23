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

package org.elasticsearch.circecodecs.types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._
import org.elasticsearch.circecodecs.types.{ double }

@JsonCodec case class DistanceParsed(
	precision: double, 
	unit: DistanceUnit
)
type Distance = String

object DistanceUnit extends Enumeration {
	type DistanceUnit = Value

	val in = Value(0, "in")
	val ft = Value(1, "ft")
	val yd = Value(2, "yd")
	val mi = Value(3, "mi")
	val nmi = Value(4, "nmi")
	val km = Value(5, "km")
	val m = Value(6, "m")
	val cm = Value(7, "cm")
	val mm = Value(8, "mm")
}

implicit val distanceUnitDecoder: Decoder[DistanceUnit.Value] = Decoder.decodeEnumeration(DistanceUnit)
implicit val distanceUnitEncoder: Encoder[DistanceUnit.Value] = Decoder.encodeEnumeration(DistanceUnit)

object GeoDistanceType extends Enumeration {
	type GeoDistanceType = Value

	val arc = Value(0, "arc")
	val plane = Value(1, "plane")
}

implicit val geoDistanceTypeDecoder: Decoder[GeoDistanceType.Value] = Decoder.decodeEnumeration(GeoDistanceType)
implicit val geoDistanceTypeEncoder: Encoder[GeoDistanceType.Value] = Decoder.encodeEnumeration(GeoDistanceType)

object GeoShapeRelation extends Enumeration {
	type GeoShapeRelation = Value

	val intersects = Value(0, "intersects")
	val disjoint = Value(1, "disjoint")
	val within = Value(2, "within")
	val contains = Value(3, "contains")
}

implicit val geoShapeRelationDecoder: Decoder[GeoShapeRelation.Value] = Decoder.decodeEnumeration(GeoShapeRelation)
implicit val geoShapeRelationEncoder: Encoder[GeoShapeRelation.Value] = Decoder.encodeEnumeration(GeoShapeRelation)
type GeoTilePrecision = Double
type GeoHashPrecision = Double

@JsonCodec case class LatLon(
	lat: double, 
	lon: double
)
