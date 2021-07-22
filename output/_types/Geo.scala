package com.converted.elasticsearch._types

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.{ double }

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
type GeoTilePrecision = Numeric
type GeoHashPrecision = Numeric

@JsonCodec case class LatLon(
	lat: double, 
	lon: double
)
