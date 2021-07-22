package com.converted.elasticsearch._types.mapping

import io.circe._, io.circe.generic.semiauto._
import io.circe.generic.JsonCodec, io.circe.syntax._

import com.converted.elasticsearch._indices._types.StringFielddata.{ StringFielddata }
import com.converted.elasticsearch._spec_utils.UserDefinedValue.{ UserDefinedValue }
import com.converted.elasticsearch._types.common.{ Field, Name }
import com.converted.elasticsearch._types.Numeric.{ double, integer }
import com.converted.elasticsearch._types.mapping.{ DocValuesPropertyBase, IndexOptions }
import com.converted.elasticsearch._types.mapping.{ PropertyBase }
import com.converted.elasticsearch._types.mapping.{ TermVectorOption }

@JsonCodec case class CompletionProperty(
	analyzer: String, 
	contexts: Array[SuggestContext], 
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
