package com.converted.elasticsearch._types.query_dsl

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._spec_utils.behaviors.{ AdditionalProperties }
import com.converted.elasticsearch._types.Geo.{ Distance, GeoDistanceType, GeoShapeRelation, LatLon }
import com.converted.elasticsearch._types.Numeric.{ double }
import com.converted.elasticsearch._types.query_dsl.{ FieldLookup, QueryBase }

@JsonCodec case class BoundingBox(
	bottom_right: GeoLocation, 
	top_left: GeoLocation, 
	wkt: String
)

@JsonCodec case class GeoBoundingBoxQuery(
	bounding_box: BoundingBox, 
	`type`: GeoExecution, 
	validation_method: GeoValidationMethod, 
	top_left: LatLon, 
	bottom_right: LatLon
) extends QueryBase

object GeoExecution extends Enumeration {
	type GeoExecution = Value

	val memory = Value(0, "memory")
	val indexed = Value(1, "indexed")
}

implicit val geoExecutionDecoder: Decoder[GeoExecution.Value] = Decoder.decodeEnumeration(GeoExecution)
implicit val geoExecutionEncoder: Encoder[GeoExecution.Value] = Decoder.encodeEnumeration(GeoExecution)

@JsonCodec case class GeoDistanceQuery(
	distance: Distance, 
	distance_type: GeoDistanceType, 
	validation_method: GeoValidationMethod
) extends QueryBase, AdditionalProperties[String, GeoLocation]

@JsonCodec case class GeoPolygonQuery(
	points: Array[GeoLocation], 
	validation_method: GeoValidationMethod
) extends QueryBase

object GeoFormat extends Enumeration {
	type GeoFormat = Value

	val geoJson = Value(0, "GeoJson")
	val wellKnownText = Value(1, "WellKnownText")
}

implicit val geoFormatDecoder: Decoder[GeoFormat.Value] = Decoder.decodeEnumeration(GeoFormat)
implicit val geoFormatEncoder: Encoder[GeoFormat.Value] = Decoder.encodeEnumeration(GeoFormat)

@JsonCodec case class GeoShape(
	`type`: String
)

@JsonCodec case class GeoShapeQuery(
	ignore_unmapped: Boolean, 
	indexed_shape: FieldLookup, 
	relation: GeoShapeRelation, 
	shape: GeoShape
) extends QueryBase

object CharacterType extends Enumeration {
	type CharacterType = Value

	val whitespace = Value(0, "Whitespace")
	val alpha = Value(1, "Alpha")
	val comment = Value(2, "Comment")
}

implicit val characterTypeDecoder: Decoder[CharacterType.Value] = Decoder.decodeEnumeration(CharacterType)
implicit val characterTypeEncoder: Encoder[CharacterType.Value] = Decoder.encodeEnumeration(CharacterType)

object TokenType extends Enumeration {
	type TokenType = Value

	val none = Value(0, "None")
	val word = Value(1, "Word")
	val lParen = Value(2, "LParen")
	val rParen = Value(3, "RParen")
	val comma = Value(4, "Comma")
}

implicit val tokenTypeDecoder: Decoder[TokenType.Value] = Decoder.decodeEnumeration(TokenType)
implicit val tokenTypeEncoder: Encoder[TokenType.Value] = Decoder.encodeEnumeration(TokenType)

@JsonCodec case class TwoDimensionalPoint(
	lat: double, 
	lon: double
)

@JsonCodec case class ThreeDimensionalPoint(
	lat: double, 
	lon: double, 
	z: double
)
type GeoLocation = String | Array[double] | TwoDimensionalPoint
type GeoCoordinate = String | Array[double] | ThreeDimensionalPoint

object GeoValidationMethod extends Enumeration {
	type GeoValidationMethod = Value

	val coerce = Value(0, "coerce")
	val ignore_malformed = Value(1, "ignore_malformed")
	val strict = Value(2, "strict")
}

implicit val geoValidationMethodDecoder: Decoder[GeoValidationMethod.Value] = Decoder.decodeEnumeration(GeoValidationMethod)
implicit val geoValidationMethodEncoder: Encoder[GeoValidationMethod.Value] = Decoder.encodeEnumeration(GeoValidationMethod)
