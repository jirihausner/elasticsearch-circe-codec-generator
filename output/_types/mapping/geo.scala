package com.converted.elasticsearch._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._types.query_dsl.geo.{ GeoLocation }
import com.converted.elasticsearch._types.mapping.{ DocValuesPropertyBase }

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
